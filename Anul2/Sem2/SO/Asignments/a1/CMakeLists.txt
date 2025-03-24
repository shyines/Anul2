cmake_minimum_required(VERSION 3.28.3)
project(a1 C)

set(CMAKE_C_STANDARD 11)

add_executable(a1 a1.c
        headers/functions.h)
