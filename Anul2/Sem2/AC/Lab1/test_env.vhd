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
        btn : in STD_LOGIC_VECTOR (4 downto 0);
        sw : in STD_LOGIC_VECTOR (15 downto 0);
        led : out STD_LOGIC_VECTOR (15 downto 0);
        an : out STD_LOGIC_VECTOR (7 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0));
end test_env;

architecture Behavioral of test_env is
signal CNT : std_logic_vector (1 downto 0) := (others => '0');
signal en : STD_LOGIC := '0';
signal s_digits: std_logic_vector (31 downto 0) := (others => '0');
signal s_sw_A: std_logic_vector(31 downto 0) := (others => '0');
signal s_sw_B: std_logic_vector(31 downto 0) := (others => '0');
signal s_sw_C: std_logic_vector(31 downto 0) := (others => '0');

--componentele: MPG-UL SI SSD-UL

component MPG
    port (enable : out STD_LOGIC;
           btn : in STD_LOGIC;
           clk : in STD_LOGIC
    );
end component;

component SSD
    port (
        digits: in std_logic_vector(31 downto 0);
        an : out STD_LOGIC_VECTOR (7 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0);
        clk: in std_logic);
end component;

begin
MonoPulseGenerator: MPG port map (
    enable => en,
    btn => btn(0),
    clk => clk
);

SevenSegmentDisplay: SSD port map (
    digits => s_digits,
    an => an,
    cat => cat,
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
led <= cnt;

--Here I implemented the ALU
process (CNT) 
begin
    case CNT is
        when "00" =>
             s_sw_A <= X"0000000" & sw(3 downto 0);
             s_sw_B <= X"0000000" & sw(7 downto 4);
             s_digits <= s_sw_A + s_sw_B;
        when "01" =>
             s_sw_A <= X"0000000" & sw(3 downto 0);
             s_sw_B <= X"0000000" & sw(7 downto 4);
             s_digits <= s_sw_A - s_sw_B;
        when "10" =>
             s_sw_C <= X"0000" & sw(7 downto 0);
             s_digits <= s_sw_C(29 downto 0) & "00";
        when "11" =>
             s_sw_C <= X"0000" & sw(7 downto 0);
             s_digits <= "00" & s_sw_C(31 downto 2);
        end case;
end process;
end Behavioral;
