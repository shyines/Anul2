----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 02/24/2025 09:02:39 PM
-- Design Name: 
-- Module Name: test_new - Behavioral
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

entity test_new is
  Port (clk : in STD_LOGIC;
        btn : in STD_LOGIC_VECTOR (4 downto 0);
        sw : in STD_LOGIC_VECTOR (15 downto 0);
        led : out STD_LOGIC_VECTOR (7 downto 0)
       -- an : out STD_LOGIC_VECTOR (7 downto 0);
       -- cat : out STD_LOGIC_VECTOR (6 downto 0));
       );
end test_new;

architecture Behavioral of test_new is

signal cnt : STD_LOGIC_VECTOR (2 downto 0) := (others => '0');
signal en : STD_LOGIC := '0';
signal decoded : STD_LOGIC_VECTOR (7 downto 0) := (others => '0');

component MPG
    port (enable : out STD_LOGIC;
           btn : in STD_LOGIC;
           clk : in STD_LOGIC
    );
end component;
begin
e: MPG port map (
    enable => en,
    btn => btn(0),
    clk => clk
);

process(CLK)
begin
if rising_edge(CLK) then
    if en = '1' then
        if sw(0) = '1' then
            CNT <= CNT + 1;
        else
            CNT <= CNT - 1;
        end if;    
    end if;
end if;
end process;
process(cnt)
begin
case cnt is
    when "000" => decoded <= "00000001";
    when "001" => decoded <= "00000010";
    when "010" => decoded <= "00000100";
    when "011" => decoded <= "00001000";
    when "100" => decoded <= "00010000";
    when "101" => decoded <= "00100000";
    when "110" => decoded <= "01000000";
    when others => decoded <= "10000000";
end case;
end process;
led <= decoded;
end Behavioral;
