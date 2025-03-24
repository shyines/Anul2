----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/06/2023 12:15:43 AM
-- Design Name: 
-- Module Name: count3 - Behavioral
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
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity count3 is
    Port ( clk : in STD_LOGIC;
           btn : in STD_LOGIC_VECTOR (4 downto 0);
           sw : in STD_LOGIC_VECTOR (15 downto 0);
           led : out STD_LOGIC_VECTOR (7 downto 0);
           an : out STD_LOGIC_VECTOR (3 downto 0);
           cat : out STD_LOGIC_VECTOR (6 downto 0));
end count3;


architecture Behavioral of count3 is

component MPG 
    Port ( en : out STD_LOGIC;
           input : in STD_LOGIC;
           clk : in STD_LOGIC);
end component;

signal count: std_logic_vector (2 downto 0);
signal enable: std_logic;

begin
    P1: MPG port map(enable,btn(0),clk);
    process(clk,sw(0), enable)
    begin
        if rising_edge(clk) then
            if sw(0) = '1' then  -- numaram crescator
                if enable = '1' then
                    count <= count + 1;
                end if;
            else -- numaram descrescator
                if enable = '1' then
                    count <= count - 1;
                end if;
            end if;
        else 
            count <= count;
        end if;
    end process;
    process(count)
    begin
        case count is
            when "000" =>led<="00000001";
            when "001" =>led<="00000010";
            when "010" =>led<="00000100";
            when "011" =>led<="00001000";
            when "100" =>led<="00010000";
            when "101" =>led<="00100000";
            when "110" =>led<="01000000";
            when others =>led<="10000000";
        end case;
    end process;
end Behavioral;