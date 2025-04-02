#include <cmath>
#include <iostream>
#include "vec2.h"

namespace egc {
    vec2& vec2::operator =(const vec2& srcVector) {
        if (this != &srcVector) {
            x = srcVector.x;
            y = srcVector.y;
        }
        return *this;
    };
    vec2 vec2::operator +(const vec2& srcVector) const{

        return vec2(x+srcVector.x, y + srcVector.y);
    }
    vec2& vec2::operator +=(const vec2& srcVector) {
        x += srcVector.x;
        y += srcVector.y;

        return *this;
    };
    vec2 vec2::operator *(float scalarValue) const {
        return vec2(x * scalarValue, y * scalarValue);
    };
    vec2 vec2::operator -(const vec2& srcVector) const {
        return vec2(x - srcVector.x, y - srcVector.y);
    };
    vec2& vec2::operator -=(const vec2& srcVector) {
        x -= srcVector.x;
        y -= srcVector.y;

        return *this;
    };
    vec2 vec2::operator -() const {
        egc::vec2 v1 = egc::vec2(1.0f, 1.0f);
        return v1;
    }

    vec2& vec2::normalize() {
        float magnitude = std::sqrt(x * x + y * y); // Calculate the magnitude
        if (magnitude != 0) { // Avoid division by zero
            x /= magnitude;   // Normalize x
            y /= magnitude;   // Normalize y
        }
        return *this;
    }

    float dotProduct(const vec2& v1, const vec2& v2) {
        return v1.x * v2.x + v1.y * v2.y;
    }
    vec2 crossProduct(const vec2& v1, const vec2& v2) {
        return v1; // nu il putem implementa
    }
}