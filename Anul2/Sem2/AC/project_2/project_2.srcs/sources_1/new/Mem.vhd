----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 04/19/2025 03:07:11 PM
-- Design Name: 
-- Module Name: Mem - Behavioral
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

entity Mem is
  Port (
        clk: in std_logic;
        MemWrite: in std_logic;
        AluResIn: in std_logic_vector (15 downto 0);
        RD2: in std_logic_vector (15 downto 0);
        MemData: out std_logic_vector (15 downto 0);
        AluResOut: out std_logic_vector (15 downto 0);
        DebugMemory: out std_logic_vector (15 downto 0);
        debugSignal: in std_logic;
        enable: in std_logic;
        rst: in std_logic );
end Mem;

architecture Behavioral of Mem is
    type mem_type is array (0 to 63) of std_logic_vector(15 downto 0);
    
    signal Memory : mem_type := (
        B"0000000000000000",
        B"0000000000000010",
        B"0000000000000011",
        B"0000000000000100",
    others => X"0000");
    
    signal debugCount: std_logic_vector(5 downto 0);
begin 

process(clk)
    begin 
    if MemWrite = '1' and rising_edge(clk) then
        memory(conv_integer(AluResIn)) <= RD2;
    end if;
    MemData <= memory(conv_integer(AluResIn));
    AluResOut <= AluResIn; 
    
    if(debugSignal = '1') then
        if(rising_edge(clk)) then
            if(rst = '1') then
                debugCount <= "000000";
            elsif (rst = '0' and enable = '1') then
                debugCount <= debugCount + 1;
                DebugMemory <= memory(conv_integer(debugCount));
            end if;
            end if;
    end if;     
end process;    




end Behavioral;
