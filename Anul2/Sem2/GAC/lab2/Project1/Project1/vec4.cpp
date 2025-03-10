#include <cmath>
#include <iostream>
#include "vec4.h"
namespace egc {
    vec4& vec4::operator =(const vec4& srcVector) {
        if (this != &srcVector) {
            x = srcVector.x;
            y = srcVector.y;
            z = srcVector.z;
            w = srcVector.w;
        }
        return *this;
    };
    vec4 vec4::operator +(const vec4& srcVector) {
       return vec4(x + srcVector.x, y + srcVector.y, z + srcVector.z, w + srcVector.w);
    }
    vec4& vec4::operator +=(const vec4& srcVector) {
        x += srcVector.x;
        y += srcVector.y;
        z += srcVector.z;
        w += srcVector.w;

        return *this;
    };
    vec4 vec4::operator *(float scalarValue) {
        return vec4(scalarValue * x, scalarValue * y, scalarValue * z, scalarValue * w);
    };
    vec4 vec4::operator -(const vec4& srcVector) {
        return vec4(x - srcVector.x, y - srcVector.y, z - srcVector.z, w - srcVector.w);
    };
    vec4& vec4::operator -=(const vec4& srcVector) {
        x -= srcVector.x;
        y -= srcVector.y;
        z -= srcVector.z;
        w -= srcVector.w;

        return *this;
    };
    vec4 vec4::operator -() {
        egc::vec4 v1 = egc::vec4(1.0f, 1.0f, 1.0f,1.0f);
        return v1;
    }

    vec4& vec4::normalize() {
        float magnitude = std::sqrt(x * x + y * y + z * z + w * w); // Calculate the magnitude
        if (magnitude != 0) { // Avoid division by zero
            x /= magnitude;   // Normalize x
            y /= magnitude;
            z /= magnitude;
            w /= magnitude; // Normalize y
        }
        return *this;
    }

    float dotProduct(const vec4& v1, const vec4& v2) {
        return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
    }
    vec4 crossProduct(const vec4& v1, const vec4& v2) {
        return v1;
    }
}