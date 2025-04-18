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
        btn: in STD_LOGIC_vector(2 downto 0);
        an : out STD_LOGIC_VECTOR (3 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0)
       );
end test_env;

architecture Behavioral of test_env is

--signal for: register file and immediate values
signal s_rd1, s_rd2, s_Ext_imm, s_Ext_sa, s_Ext_func: std_logic_vector(15 downto 0);
signal s_func: std_logic_vector(2 downto 0);

--UC signals
signal s_RegDst, s_ExtOp, s_ALUSrc, s_Branch, s_Jump, s_MemWrite, s_MemtoReg, s_RegWrite, s_sa: std_logic;
signal s_AluOp: std_logic_vector (2 downto 0);

--instruction from the instruction fetcher
signal s_instruction: std_logic_vector(15 downto 0);


--program counter
signal s_pc: std_logic_vector(15 downto 0);


signal s_en: std_logic;
signal s_digits: std_logic_vector(15 downto 0);
signal s_rst: std_logic;
signal s_regwrite_btn: std_logic;

--data to be written in rf
signal s_wd: std_logic_vector(15 downto 0);

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
           sa: out std_logic
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

begin
inst_IF: I_Fetch port map (
    rst => s_rst,
    clk => clk,
    jump_address => X"0004",
    branch_address => X"0000",
    jump => sw(0),
    PCSrc => sw(1),
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

mpg_reg_write: mpg port map (
    enable => s_regwrite_btn,
    btn => btn(2),
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
    RegWrite => s_regwrite_btn,
    Instr => s_Instruction,
    RegDst=> s_RegDst,
    ExtOp => s_ExtOp,
    WD => s_WD,
    RD1 => s_rd1,
    RD2 => s_rd2,
    Ext_imm => s_Ext_imm,
    func => s_func,
    sa => s_sa 
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




with sw(7 downto 5) select
    s_digits <= s_instruction when "000",
                s_pc  when "001",
                s_RD1 when "010",
                s_RD2 when "011",
                s_Ext_imm when "101",
                s_Ext_func when "110",
                s_Ext_sa when "111",
                (others => 'X') when others;
    led(10 downto 0) <= s_AluOp & s_RegDst & s_ExtOp & s_AluSrc & s_Branch & s_Jump & s_MemWrite & s_MemToReg & s_RegWrite;
end Behavioral;
