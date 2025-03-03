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
signal sel: std_logic_vector(16 downto 0);

begin
    process
        begin
            if(rising_edge(clk)) then
                counter <= counter + 1;
            end if;
        end process;
  sel <= counter;
  
process(sel) is
    case sel is
        when "0000" =>
            an = "11111110";
        when "0001" =>
            an = "11111110"
        when "0010" =>
            an = "11111110"
        when "0011" =>
            an = "11111110"            
        when "0100" =>
            an = "11111110"               
        when "0101" =>
            an = "11111110"
        when "0110" =>
            an = "11111110"      
         when "0111" =>
            an = "11111110"   
      end case;        
end process;            
            
process (sel) is
    case sel
        
    when
    end case; 
end process;             
end Behavioral;
