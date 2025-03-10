cmake_minimum_required(VERSION 3.30)
project(SetupSDL3Try3)

set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)

set(CMAKE_CXX_STANDARD 20)

add_executable(SetupSDL3Try3 main.cpp)
target_compile_features(${PROJECT_NAME} PRIVATE cxx_std_23)



#CPM
file(
        DOWNLOAD
        https://github.com/cpm-cmake/CPM.cmake/releases/download/v0.38.3/CPM.cmake
        ${CMAKE_CURRENT_BINARY_DIR}/cmake/CPM.cmake
        EXPECTED_HASH SHA256=cc155ce02e7945e7b8967ddfaff0b050e958a723ef7aad3766d368940cb15494
)
include(${CMAKE_CURRENT_BINARY_DIR}/cmake/CPM.cmake)

set(LIBS)

##Dependencies

#SDL
CPMAddPackage("gh:libsdl-org/SDL#7c29c8b")
list(APPEND LIBS SDL3::SDL3)