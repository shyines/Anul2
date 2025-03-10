#include <cmath>
#include <iostream>
#include "vec3.h"

namespace egc {
    vec3& vec3::operator =(const vec3& srcVector) {
        if (this != &srcVector) {
            x = srcVector.x;
            y = srcVector.y;
            z = srcVector.z;
        }
        return *this;
    };
    vec3 vec3::operator +(const vec3& srcVector) {
        return vec3(x + srcVector.x, y + srcVector.y, z + srcVector.z);
    }
    vec3& vec3::operator +=(const vec3 & srcVector) {
        x += srcVector.x;
        y += srcVector.y;
        z += srcVector.z;

        return *this;
    };
    vec3 vec3::operator *(float scalarValue) {
        return egc::vec3(scalarValue * x, scalarValue * y, scalarValue * z);
    };
    vec3 vec3::operator -(const vec3& srcVector) {
        return vec3(x - srcVector.x, y - srcVector.y, z - srcVector.z);
    };
    vec3& vec3::operator -=(const vec3& srcVector) {
        x -= srcVector.x;
        y -= srcVector.y;
        z -= srcVector.z;

        return *this;
    };
    vec3 vec3::operator -() {
        egc::vec3 v1 = egc::vec3 (1.0f, 1.0f, 1.0f);
        return v1;
    }

    vec3& vec3::normalize() {
        float magnitude = std::sqrt(x * x + y * y + z * z); // Calculate the magnitude
        if (magnitude != 0) { // Avoid division by zero
            x /= magnitude;   // Normalize x
            y /= magnitude;
            z /= magnitude; // Normalize y
        }
        return *this;
    }

    float dotProduct(const vec3& v1, const vec3& v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    }
    vec3 crossProduct(const vec3& v1, const vec3& v2) {
        return vec3(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
    }
}