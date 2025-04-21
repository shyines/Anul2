----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 02/24/2025 03:16:48 PM
-- Design Name: 
-- Module Name: test_env - Behavioral
-- Project Name: 
-- Target Devices: 
-- Tool Versions: 
-- Description: 
-- 
-- Dependencies: 
-- 
-- Revision:
-- Revision 0.01 - File Created
-- Additional Comments:
-- 
----------------------------------------------------------------------------------


library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity test_env is
  Port (clk : in STD_LOGIC;
        sw: in std_logic_vector(7 downto 0);
        led: out std_logic_vector (10 downto 0);
        btn: in STD_LOGIC_vector(3 downto 0);
        an : out STD_LOGIC_VECTOR (3 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0)
       );
end test_env;

architecture Behavioral of test_env is

--signal for: register file and immediate values
signal s_rd1, s_rd2, s_Ext_imm, s_Ext_sa, s_Ext_func: std_logic_vector(15 downto 0);
signal s_func: std_logic_vector(2 downto 0);

--extra signals
signal s_pcSrc: std_logic;
signal s_jump_address: std_logic_vector (15 downto 0);

--UC signals
signal s_RegDst, s_ExtOp, s_ALUSrc, s_Branch, s_Jump, s_MemWrite, s_MemtoReg, s_RegWrite, s_sa: std_logic;
signal s_AluOp: std_logic_vector (2 downto 0);

--instruction from the instruction fetcher
signal s_instruction: std_logic_vector(15 downto 0);

--program counter
signal s_pc: std_logic_vector(15 downto 0);

--EXECUTION UNIT RESULT
signal s_AluRes: std_logic_vector (15 downto 0);
signal s_zero: std_logic;
signal s_branch_address: std_logic_vector (15 downto 0);

--memory
signal s_MemData: std_logic_vector (15 downto 0);
signal s_AluResOut: std_logic_vector (15 downto 0);

signal s_en: std_logic;
signal s_digits: std_logic_vector(15 downto 0);
signal s_rst: std_logic;
signal s_regwrite_btn: std_logic;

--data to be written in rf
signal s_wd: std_logic_vector(15 downto 0);


--DEBUG SIGNALS
signal s_debugmemory: std_logic_vector(15 downto 0);
signal s_en_debug: std_logic;
signal s_rst_debug_rst: std_logic;

signal s_reg_debug: std_logic_vector(15 downto 0);


--componentele: MPG-UL SI SSD-UL

component I_Fetch --instruction fetcher
    port (rst: in std_logic;
        clk: in std_logic;
        jump_address: in std_logic_vector (15 downto 0);
        branch_address: in std_logic_vector(15 downto 0);
        jump: in std_logic;
        PCSrc: in std_logic;
        PC: out std_logic_vector (15 downto 0);
        en: in std_logic;
        instruction: out std_logic_vector(15 downto 0)
    );
end component;

component SSD
    port (
        digits: in std_logic_vector(15 downto 0);
        an : out STD_LOGIC_VECTOR (3 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0);
        clk: in std_logic);
end component;

component mpg
    Port ( enable : out STD_LOGIC;
           btn : in STD_LOGIC;
           clk : in STD_LOGIC);
end component;

component ID --instruction decoder
     Port ( clk: in std_logic;
           RegWrite: in std_logic;
           Instr: in std_logic_vector(15 downto 0);
           RegDst: in std_logic;
           ExtOp: in std_logic;
           WD: in std_logic_vector(15 downto 0);
           RD1: out std_logic_vector(15 downto 0);
           RD2: out std_logic_vector(15 downto 0);
           Ext_imm: out std_logic_vector(15 downto 0);
           func: out std_logic_vector(2 downto 0);
           sa: out std_logic;
           debugSignal_ID: in std_logic;
           enable_ID: in std_logic;
           rst_ID: in std_logic;
           DebugReg_ID: out std_logic_vector(15 downto 0)
           );
end component;

component UC --control unit
    Port (
          clk: in std_logic;
          instr: in std_logic_vector(2 downto 0);
          RegDst: out std_logic;
          ExtOp: out std_logic;
          ALUSrc: out std_logic;
          Branch: out std_logic;
          Jump: out std_logic;
          ALUOp: out std_logic_vector(2 downto 0);
          MemWrite: out std_logic;
          MemtoReg: out std_logic;
          RegWrite: out std_logic);
end component;

component ExecutionUnit
    Port (
          AluOp: in std_logic_vector(2 downto 0);
          func: in std_logic_vector(2 downto 0);
          sa: in std_logic;
          rd2: in std_logic_vector(15 downto 0);
          rd1: in std_logic_vector(15 downto 0);
          AluSrc: in std_logic;
          Ext_imm: in std_logic_vector(15 downto 0);
          AluRes: out std_logic_vector (15 downto 0);
          zero: out std_logic;
          pc: in std_logic_vector (15 downto 0);
          branch_address: out std_logic_vector (15 downto 0)
         );
end component;

component Mem
      Port (
        clk: in std_logic;
        MemWrite: in std_logic;
        AluResIn: in std_logic_vector (15 downto 0);
        RD2: in std_logic_vector (15 downto 0);
        MemData: out std_logic_vector (15 downto 0);
        AluResOut: out std_logic_vector (15 downto 0);
        DebugMemory: out std_logic_vector (15 downto 0);
        debugSignal: in std_logic;
        enable: in std_logic;
        rst: in std_logic );
end component;


begin
inst_IF: I_Fetch port map (
    rst => s_rst,
    clk => clk,
    jump_address => s_jump_address,
    branch_address => s_branch_address,
    jump => s_jump,
    PCSrc => s_pcSrc,
    PC => s_pc,
    en => s_en,
    instruction => s_instruction
);

mpg_i_fetch: mpg port map (
    enable => s_en,
    btn => btn(0),
    clk => clk
);

mpg_rst: mpg port map (
    enable => s_rst,
    btn => btn(1),
    clk => clk
);

mpg_debug_en: mpg port map (
    enable => s_en_debug,
    btn => btn(2),
    clk => clk
);

mpg_debug_rst: mpg port map (
    enable => s_rst_debug_rst,
    btn => btn(3),
    clk => clk
);

SevenSegmentDisplay: SSD port map (
    digits => s_digits,
    an => an,
    cat => cat,
    clk => clk 
);

InstructionDecode: ID port map (
    clk => clk,
    RegWrite => s_RegWrite,
    Instr => s_Instruction,
    RegDst=> s_RegDst,
    ExtOp => s_ExtOp,
    WD => s_WD,
    RD1 => s_rd1,
    RD2 => s_rd2,
    Ext_imm => s_Ext_imm,
    func => s_func,
    sa => s_sa,
    debugSignal_ID => sw(3),
    enable_ID => s_en_debug,
    rst_id => s_rst_debug_rst,
    DebugReg_ID => s_reg_debug
);

MainControl: UC port map (
          clk => clk,
          instr => s_instruction(15 downto 13),
          RegDst => s_RegDst,
          ExtOp => s_ExtOp,
          ALUSrc => s_ALUSrc,
          Branch => s_Branch,
          Jump => s_Jump,
          ALUOp => s_ALUOp,
          MemWrite => s_MemWrite,
          MemtoReg => s_MemtoReg,
          RegWrite => s_RegWrite
);

Execution_Unit: ExecutionUnit port map (
          AluOp => s_ALUOp,
          func => s_func,
          sa => s_sa,
          rd2 => s_rd2,
          rd1 => s_rd1,
          AluSrc => s_ALUSrc,
          Ext_imm => s_Ext_imm,
          AluRes => s_AluRes,
          zero => s_zero,
          pc => s_pc,
          branch_address => s_branch_address
);

MemoryUnit: Mem port map (
          clk => clk,
          MemWrite => s_MemWrite,
          AluResIn => s_AluRes,
          RD2 => s_rd2,
          MemData => s_MemData,
          AluResOut => s_AluResOut,
          DebugMemory => s_debugmemory,
          debugSignal => sw(4),
          enable => s_en_debug,
          rst => s_rst_debug_rst
);

s_jump_address <= s_pc(15 downto 13) & s_Instruction(12 downto 0);
s_pcSrc <= s_zero and s_branch;

with s_MemToReg select
    s_wd <= s_MemData when '1',
            s_AluResOut when '0',
         (others => 'X') when others;

with sw(7 downto 3) select
    s_digits <= s_reg_debug when "00001",
                s_debugmemory when "00010",
                s_instruction when "00000",
                s_pc  when "00100",
                s_RD1 when "01000",
                s_RD2 when "01100",
                s_Ext_imm when "10000",
                s_AluRes when "10100",
                s_MemData when "11000", 
                s_WD when "11100",
                (others => 'X') when others;
    led(10 downto 0) <= s_AluOp & s_RegDst & s_ExtOp & s_AluSrc & s_Branch & s_Jump & s_MemWrite & s_MemToReg & s_RegWrite;
end Behavioral;
