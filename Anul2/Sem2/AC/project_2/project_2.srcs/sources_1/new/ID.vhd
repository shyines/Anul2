----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 04/03/2025 05:09:37 PM
-- Design Name: 
-- Module Name: ID - Behavioral
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

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity ID is
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
end ID;

architecture Behavioral of ID is

component register_file is
            port ( 
           clk: in std_logic;
           reg_write: in std_logic; 
           read_addr_1: in std_logic_vector(2 downto 0);
           read_addr_2: in std_logic_vector(2 downto 0);
           write_addr: in std_logic_vector(2 downto 0);
           write_data: in std_logic_vector(15 downto 0);
           read_data_1: out std_logic_vector(15 downto 0);
           read_data_2: out std_logic_vector(15 downto 0);
           debugSignal: in std_logic;
           enable: in std_logic;
           rst: in std_logic;
           DebugReg: out std_logic_vector(15 downto 0)
           );
end component;

signal WriteAddress: std_logic_vector(2 downto 0);

begin
    with RegDst select
        WriteAddress <= Instr(6 downto 4) when '1',
                        Instr(9 downto 7) when '0',
                        (others => 'X') when others;
                        
                        
    Ext_imm(6 downto 0) <= Instr(6 downto 0);
    Ext_imm(15 downto 7) <= (others => Instr(15)) when ExtOp = '1' else
                            (others => '0');
    
    func <= instr(2 downto 0);
    sa <= instr(3);                       
                                       
reg_file: register_file port map(
    clk => clk,
    reg_write => RegWrite,
    read_addr_1 => Instr (12 downto 10),
    read_addr_2 => Instr (9 downto 7),
    write_addr => WriteAddress,
    write_data => WD,
    read_data_1 => RD1,
    read_data_2 => RD2,
    debugSignal => debugSignal_ID,
    enable => enable_ID,
    rst => rst_id,
    DebugReg => debugreg_id
);

end Behavioral;
