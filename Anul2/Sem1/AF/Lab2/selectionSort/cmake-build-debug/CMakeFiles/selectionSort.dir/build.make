# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.28

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\Apps\Clion\CLion 2024.1.4\bin\cmake\win\x64\bin\cmake.exe"

# The command to remove a file.
RM = "D:\Apps\Clion\CLion 2024.1.4\bin\cmake\win\x64\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/selectionSort.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/selectionSort.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/selectionSort.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/selectionSort.dir/flags.make

CMakeFiles/selectionSort.dir/main.cpp.obj: CMakeFiles/selectionSort.dir/flags.make
CMakeFiles/selectionSort.dir/main.cpp.obj: D:/Apps/Docs/Facultate/Anul2/Anul2/Sem1/AF/Lab2/selectionSort/main.cpp
CMakeFiles/selectionSort.dir/main.cpp.obj: CMakeFiles/selectionSort.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --progress-dir=D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/selectionSort.dir/main.cpp.obj"
	"D:\Apps\Clion\CLion 2024.1.4\bin\mingw\bin\g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/selectionSort.dir/main.cpp.obj -MF CMakeFiles\selectionSort.dir\main.cpp.obj.d -o CMakeFiles\selectionSort.dir\main.cpp.obj -c D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\main.cpp

CMakeFiles/selectionSort.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Preprocessing CXX source to CMakeFiles/selectionSort.dir/main.cpp.i"
	"D:\Apps\Clion\CLion 2024.1.4\bin\mingw\bin\g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\main.cpp > CMakeFiles\selectionSort.dir\main.cpp.i

CMakeFiles/selectionSort.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green "Compiling CXX source to assembly CMakeFiles/selectionSort.dir/main.cpp.s"
	"D:\Apps\Clion\CLion 2024.1.4\bin\mingw\bin\g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\main.cpp -o CMakeFiles\selectionSort.dir\main.cpp.s

# Object files for target selectionSort
selectionSort_OBJECTS = \
"CMakeFiles/selectionSort.dir/main.cpp.obj"

# External object files for target selectionSort
selectionSort_EXTERNAL_OBJECTS =

selectionSort.exe: CMakeFiles/selectionSort.dir/main.cpp.obj
selectionSort.exe: CMakeFiles/selectionSort.dir/build.make
selectionSort.exe: CMakeFiles/selectionSort.dir/linkLibs.rsp
selectionSort.exe: CMakeFiles/selectionSort.dir/objects1.rsp
selectionSort.exe: CMakeFiles/selectionSort.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color "--switch=$(COLOR)" --green --bold --progress-dir=D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable selectionSort.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\selectionSort.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/selectionSort.dir/build: selectionSort.exe
.PHONY : CMakeFiles/selectionSort.dir/build

CMakeFiles/selectionSort.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\selectionSort.dir\cmake_clean.cmake
.PHONY : CMakeFiles/selectionSort.dir/clean

CMakeFiles/selectionSort.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\cmake-build-debug D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\cmake-build-debug D:\Apps\Docs\Facultate\Anul2\Anul2\Sem1\AF\Lab2\selectionSort\cmake-build-debug\CMakeFiles\selectionSort.dir\DependInfo.cmake "--color=$(COLOR)"
.PHONY : CMakeFiles/selectionSort.dir/depend

