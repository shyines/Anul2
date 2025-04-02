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
        led: out std_logic_vector (7 downto 0);
        btn: in STD_LOGIC_vector(1 downto 0);
        an : out STD_LOGIC_VECTOR (3 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0)
       );
end test_env;

architecture Behavioral of test_env is

signal s_instruction: std_logic_vector(15 downto 0);
signal s_pc: std_logic_vector(15 downto 0);
signal s_en: std_logic;
signal s_digits: std_logic_vector(15 downto 0);
signal s_rst: std_logic;
--componentele: MPG-UL SI SSD-UL

component I_Fetch
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

SevenSegmentDisplay: SSD port map (
    digits => s_digits,
    an => an,
    cat => cat,
    clk => clk 
);

with sw(7) select
    s_digits <= s_pc when '1',
                s_instruction when '0',
                (others => 'X') when others;
    led(7) <= sw(7);
    led(0) <= sw(0);
    led(1) <= sw(1);
end Behavioral;
