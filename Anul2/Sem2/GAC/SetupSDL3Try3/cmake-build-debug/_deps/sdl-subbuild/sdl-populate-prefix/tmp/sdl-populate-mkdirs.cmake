# Distributed under the OSI-approved BSD 3-Clause License.  See accompanying
# file Copyright.txt or https://cmake.org/licensing for details.

cmake_minimum_required(VERSION 3.5)

# If CMAKE_DISABLE_SOURCE_CHANGES is set to true and the source directory is an
# existing directory in our source tree, calling file(MAKE_DIRECTORY) on it
# would cause a fatal error, even though it would be a no-op.
if(NOT EXISTS "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-src")
  file(MAKE_DIRECTORY "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-src")
endif()
file(MAKE_DIRECTORY
  "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-build"
  "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix"
  "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix/tmp"
  "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix/src/sdl-populate-stamp"
  "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix/src"
  "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix/src/sdl-populate-stamp"
)

set(configSubDirs )
foreach(subDir IN LISTS configSubDirs)
    file(MAKE_DIRECTORY "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix/src/sdl-populate-stamp/${subDir}")
endforeach()
if(cfgdir)
  file(MAKE_DIRECTORY "D:/Facultate/Anul2/Anul2/Sem2/GAC/SetupSDL3Try3/cmake-build-debug/_deps/sdl-subbuild/sdl-populate-prefix/src/sdl-populate-stamp${cfgdir}") # cfgdir has leading slash
endif()
