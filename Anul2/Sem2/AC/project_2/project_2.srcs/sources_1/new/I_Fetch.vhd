----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/24/2025 02:53:06 PM
-- Design Name: 
-- Module Name: I_Fetch - Behavioral
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
use ieee.std_logic_unsigned.all;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity I_Fetch is 
    port ( 
        rst: in std_logic;
        clk: in std_logic;
        jump_address: in std_logic_vector (15 downto 0);
        branch_address: in std_logic_vector(15 downto 0);
        jump: in std_logic;
        PCSrc: in std_logic;
        PC: out std_logic_vector (15 downto 0);
        en: in std_logic;
        instruction: out std_logic_vector(15 downto 0)
    );
end I_Fetch;

architecture Behavioral of I_Fetch is

type rom is array(0 to 255) of std_logic_vector(15 downto 0);
signal trom: rom := (
    
    B"000_101_110_101_0_000" , --1
    B"000_101_110_101_0_001" , --2


    B"001_000_001_0000000", --X"2080" -- ADDI $1, $0, 0     -3
    B"001_000_010_0000001", --X"2101" -- ADDI $2, $0, 1     -4
    B"001_000_011_0000000", --X"2180" -- ADDI $3, $0, 0     -5
    B"001_000_100_0000001", --X"2201" -- ADDI $4, $0, 1     -6
    B"011_011_001_0000000", --X"6C80" -- SW $1, $0, 0($3)   -7
    B"011_100_010_0000000", --X"7100" -- SW $2, 0 ($4)      -8
    B"010_011_001_0000000", --X"4C80" -- LW $1, 0 ($3)      -9
    B"010_100_010_0000000", --X"5100" -- LW $2, 0 ($4)      -10
    B"000_001_010_101_0_000", --X"0550" -- ADD $5, $1, $2   -11
    B"000_000_010_001_0_000", --X"0110" -- ADD $1, $0, $2   -12
    B"000_000_101_010_0_000", --X"02A0" -- ADD $2, $0, $5   -13
    B"111_0000000001010", -- X"E00A" -- J 10                -14
    
    others => X"0000"
);
signal s_pc: std_logic_vector(15 downto 0) := (others => '0');

begin

---instruction adress

process(clk) is
begin
    if(rising_edge(clk)) then
        if(rst = '1') then
        s_pc <= X"0000";
        elsif(rst = '0' and en = '1') then
            if(jump = '1') then
                s_pc <= jump_address;
            elsif(PCSrc = '1') then
                s_pc <= branch_address;
            else
                s_pc <= s_pc + 1;
            end if;
         end if;
     end if;
 end process;
pc <= s_pc;
instruction <= trom(conv_integer(s_pc));
end Behavioral;
