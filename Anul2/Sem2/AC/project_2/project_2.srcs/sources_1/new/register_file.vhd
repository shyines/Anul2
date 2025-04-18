----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 03/21/2025 08:01:27 PM
-- Design Name: 
-- Module Name: register_file - Behavioral
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

entity register_file is
    port ( 
           clk: in std_logic;
           reg_write: in std_logic; 
           read_addr_1: in std_logic_vector(2 downto 0);
           read_addr_2: in std_logic_vector(2 downto 0);
           write_addr: in std_logic_vector(2 downto 0);
           write_data: in std_logic_vector(15 downto 0);
           read_data_1: out std_logic_vector(15 downto 0);
           read_data_2: out std_logic_vector(15 downto 0)
           );
end register_file;

architecture Behavioral of register_file is
type registers is array(0 to 4) of std_logic_vector(15 downto 0);
signal regs: registers := (others => X"0000");

begin
    process(clk)
        begin
            if(rising_edge (clk)) then
                if(reg_write = '1') then
                    regs(conv_integer(write_addr)) <= write_data; 
                end if;
            end if;
            read_data_1 <= regs(conv_integer(read_addr_1));
            read_data_2 <= regs(conv_integer(read_addr_2));
    end process;

end Behavioral;
