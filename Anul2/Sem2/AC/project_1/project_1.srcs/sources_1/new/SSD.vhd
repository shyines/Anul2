----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/03/2025 03:25:51 PM
-- Design Name: 
-- Module Name: SSD - Behavioral
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

entity SSD is
   Port(digits: in std_logic_vector(31 downto 0);
        an : out STD_LOGIC_VECTOR (7 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0);
        clk: in std_logic);
end SSD;

architecture Behavioral of SSD is

signal counter: std_logic_vector(16 downto 0) := (others => '0');
signal sel: std_logic_vector(3 downto 0);
signal number: std_logic_vector(3 downto 0);
begin
    process(clk)
        begin
            if rising_edge(clk) then
                counter <= counter + 1;
            end if;
    end process;
sel <= counter(16 downto 14);
process(sel)
begin
    case sel is
        when "000" =>
            an <= "11111110";
        when "001" =>
            an <= "11111101";
        when "010" =>
            an <= "11111011";
        when "011" =>
            an <= "11110111";         
        when "100" =>
            an <= "11101111";      
        when "101" =>
            an <= "11011111";
        when "110" =>
            an <= "10111111";     
        when "111" =>
            an <= "01111111";   
        when others =>
            an <= "11111111";
      end case;        
end process;            
            
process (sel)
begin
    case sel is
        when "000" =>
            number <= digits (3 downto 0);
        when "001" =>
            number <= digits (7 downto 4);
        when "010" =>
            number <= digits (11 downto 8);
        when "011" =>
            number <= digits (15 downto 12);         
        when "100" =>
            number <= digits (19 downto 16);      
        when "101" =>
            number <= digits (23 downto 20);
        when "110" =>
            number <= digits(27 downto 24);     
        when "111" =>
            number <= digits(31 downto 28);
        when others =>
            number <= "0000";
    end case;
end process;            
            
process (number) is
    begin
        case number is
            when "0000" => cat <= "0000001"; -- "0"     
            when "0001" => cat <= "1001111"; -- "1" 
            when "0010" => cat <= "0010010"; -- "2" 
            when "0011" => cat <= "0000110"; -- "3" 
            when "0100" => cat <= "1001100"; -- "4" 
            when "0101" => cat <= "0100100"; -- "5" 
            when "0110" => cat <= "0100000"; -- "6" 
            when "0111" => cat <= "0001111"; -- "7" 
            when "1000" => cat <= "0000000"; -- "8"     
            when "1001" => cat <= "0000100"; -- "9" 
            when "1010" => cat <= "0000010"; -- a
            when "1011" => cat <= "1100000"; -- b
            when "1100" => cat <= "0110001"; -- C
            when "1101" => cat <= "1000010"; -- d
            when "1110" => cat <= "0110000"; -- E
            when "1111" => cat <= "0111000"; -- F  
        end case; 
    end process;             
end Behavioral;
