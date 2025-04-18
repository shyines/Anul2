----------------------------------------------------------------------------------
-- Company: 
-- Engineer: 
-- 
-- Create Date: 04/03/2025 05:42:34 PM
-- Design Name: 
-- Module Name: UC - Behavioral
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
use IEEE.std_logic_unsigned.all;
-- Uncomment the following library declaration if using
-- arithmetic functions with Signed or Unsigned values
--use IEEE.NUMERIC_STD.ALL;

-- Uncomment the following library declaration if instantiating
-- any Xilinx leaf cells in this code.
--library UNISIM;
--use UNISIM.VComponents.all;

entity UC is
    Port (
          clk: in std_logic;
          instr: in std_logic_vector(2 downto 0);
          RegDst: out std_logic;
          ExtOp: out std_logic;
          ALUSrc: out std_logic;
          Branch: out std_logic;
          Jump: out std_logic;
          ALUOp: out std_logic_vector(2 downto 0);
          MemWrite: out std_logic;
          MemtoReg: out std_logic;
          RegWrite: out std_logic);
end UC;

architecture Behavioral of UC is

begin
    process(instr)
      begin
        case instr is
            when "000" => --ADD
                ALUOp <= "000";
                RegDst <= '1';
                ExtOp <= 'X';
                ALUSrc <= '0';
                Branch <= '0';
                Jump <= '0';
                MemWrite <= '0';
                MemtoReg <= '0';
                RegWrite <= '1';
            when "001" => --ADDI
                ALUOp <= "000";
                RegDst <= '1';
                ExtOp <= 'X';
                ALUSrc <= '0';
                Branch <= '0';
                Jump <= '0';
                MemWrite <= '0';
                MemtoReg <= '0';
                RegWrite <= '1';
             when "011" => --SW
                ALUOp <= "001";
                RegDst <= 'X';
                ExtOp <= '1';
                ALUSrc <= '1';
                Branch <= '0';
                Jump <= '0';
                MemWrite <= '1';
                MemtoReg <= 'X';
                RegWrite <= '1';
             when "010" => --LW
                ALUOp <= "001";
                RegDst <= '0';
                ExtOp <= '1';
                ALUSrc <= '1';
                Branch <= '0';
                Jump <= '0';
                MemWrite <= '0';
                MemtoReg <= '1';
                RegWrite <= '1';
             when "111" => --JUMP
                ALUOp <= "000";
                RegDst <= 'X';
                ExtOp <= 'X';
                ALUSrc <= 'X';
                Branch <= 'X';
                Jump <= '1';
                MemWrite <= '0';
                MemtoReg <= 'X';
                RegWrite <= '0';       
             when others =>
                ALUOp <= "XXX";
                RegDst <= 'X';
                ExtOp <= 'X';
                ALUSrc <= 'X';
                Branch <= 'X';
                Jump <= 'X';
                MemWrite <= 'X';
                MemtoReg <= 'X';
                RegWrite <= 'X';
        end case;
    end process;
end Behavioral;
