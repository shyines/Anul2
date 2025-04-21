----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 04/17/2025 09:03:44 PM
-- Design Name: 
-- Module Name: ExectionUnit - Behavioral
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
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity ExecutionUnit is
  Port (AluOp: in std_logic_vector(2 downto 0);
        func: in std_logic_vector(2 downto 0);
        sa: in std_logic;
        rd2: in std_logic_vector(15 downto 0);
        rd1: in std_logic_vector(15 downto 0);
        AluSrc: in std_logic;
        Ext_imm: in std_logic_vector(15 downto 0);
        AluRes: out std_logic_vector (15 downto 0);
        zero: out std_logic;
        pc: in std_logic_vector (15 downto 0);
        branch_address: out std_logic_vector (15 downto 0));
end ExecutionUnit;

architecture Behavioral of ExecutionUnit is

signal AluIn2: std_logic_vector (15 downto 0);
signal AluCtrl: std_logic_vector (2 downto 0);
signal s_alures: std_logic_vector (15 downto 0);
begin
--mux: either a immediate opp or a register opp
with AluSrc select
    AluIn2 <= rd2 when '0',
              ext_imm when '1',
              (others => 'X') when others;
              
--Alu Control

process(AluOp, func)
    begin
        case AluOp is
            when "000" => --R type
                case func is
                    when "000" => AluCtrl <= "000"; --Add opp
                    when "001" => AluCtrl <= "001"; --sub opp
                    when "010" => AluCtrl <= "010"; --SLL
                    when "011" => AluCtrl <= "011"; --SRL
                    when "100" => AluCtrl <= "100"; --AND
                    when "101" => AluCtrl <= "101"; --OR
                    when "110" => AluCtrl <= "110"; --XOR
                    when "111" => AluCtrl <= "111"; --SLT
                    when others => AluCtrl <= (others => 'X'); --undefined
                end case;
             when "001" => AluCtrl <= "000"; -- +
             when "010" => AluCtrl <= "001"; -- -
             when "101" => AluCtrl <= "100"; -- &
             when "110" => AluCtrl <= "101"; -- |
             when others => AluCtrl <= (others => 'X'); --undefined 
        end case;
end process;



process(AluCtrl, Rd1, AluIn2, sa)
    begin
        case AluCtrl is
            when "000" => -- add
                s_alures <= Rd1 + AluIn2;
            when "001" => -- sub
                s_alures <= Rd1 - AluIn2;
            when "010" => -- sll
                s_alures <= to_stdlogicvector(to_bitvector(rd1) sll conv_integer(AluIn2));
            when "011" => -- srl
                s_alures <= to_stdlogicvector(to_bitvector(rd1) srl conv_integer(AluIn2));
            when "100" => -- and
                s_alures <= Rd1 and AluIn2;
            when "101" => -- or
                s_alures <= Rd1 or AluIn2;
            when "110" =>
                s_alures <= Rd1 xor AluIn2;
            when others =>
                s_alures <= (others => 'X');
        end case;
end process;

--result of the opperations
AluRes <= s_alures;

branch_address <= pc + 1 + ext_imm(13 downto 0);

--we deduce the zero signal
zero <= '1' when s_alures = 0 else '0';
end Behavioral;
