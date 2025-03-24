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
        btn : in STD_LOGIC_VECTOR (2 downto 0);
        an : out STD_LOGIC_VECTOR (3 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0);
        led: out std_logic_vector(4 downto 0));
end test_env;

architecture Behavioral of test_env is

signal cnt : std_logic_vector (4 downto 0) := (others => '0');
signal en : STD_LOGIC := '0';
signal en_register_write: std_logic := '0';
signal s_digits: std_logic_vector (15 downto 0) := (others => '0');
signal rd1: std_logic_vector (15 downto 0) := (others => '0');
signal rd2: std_logic_vector (15 downto 0) := (others => '0');
signal wd: std_logic_vector (15 downto 0) := (others => '0');

--componentele: MPG-UL SI SSD-UL

component MPG
    port (enable : out STD_LOGIC;
           btn : in STD_LOGIC;
           clk : in STD_LOGIC
    );
end component;

component SSD
    port (
        digits: in std_logic_vector(15 downto 0);
        an : out STD_LOGIC_VECTOR (3 downto 0);
        cat : out STD_LOGIC_VECTOR (6 downto 0);
        clk: in std_logic);
end component;

component register_file 
    port (
           clk: in std_logic;
           reg_write: in std_logic; 
           read_addr_1: in std_logic_vector(4 downto 0);
           read_addr_2: in std_logic_vector(4 downto 0);
           write_addr: in std_logic_vector(4 downto 0);
           write_data: in std_logic_vector(15 downto 0);
           read_data_1: out std_logic_vector(15 downto 0);
           read_data_2: out std_logic_vector(15 downto 0)
          );
end component;

begin
mpg_cnt: MPG port map (
    enable => en,
    btn => btn(0),
    clk => clk
);

mpg_reg_file: mpg port map (
    enable => en_register_write,
    btn => btn(1),
    clk => clk
);

SevenSegmentDisplay: SSD port map (
    digits => s_digits,
    an => an,
    cat => cat,
    clk => clk 
);

reg_file: register_file port map (
    clk => clk,
    reg_write => en_register_write,
    read_addr_1 => cnt,
    read_addr_2 => cnt,
    write_addr => cnt,
    write_data => wd,
    read_data_1 => rd1,
    read_data_2 => rd2
);

---En counter

process(CLK)
begin
if rising_edge(CLK) then
    if en = '1' then      
        CNT <= CNT + 1;
    end if;
end if;

if(btn(2) = '1') then
   cnt <= "00000";
end if;
end process;

led <= cnt;

process(clk)
begin
    if(rising_edge(clk))then
        s_digits <= rd1 + rd2;
        wd <= s_digits;
    end if;
end process;


end Behavioral;
