#include <algorithm>
#include <iostream>
#include "mat3.h" 

namespace egc {
    mat3& mat3::operator =(const mat3& srcMatrix) {
        for (int i = 0; i < 9; i++) {
            matrixData[i] = srcMatrix.matrixData[i];  
        }
        return *this;
    }

    mat3 mat3::operator *(float scalarValue) const {
        mat3 result;
        for (int i = 0; i < 9; i++) {
            result.matrixData[i] = matrixData[i] * scalarValue;
        }
        return result;
    }


    mat3 mat3::operator *(const mat3& srcMatrix) const {
        mat3 result;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result.at(row, col) = 0;
                for (int k = 0; k < 3; k++) {
                    result.at(row, col) += at(row, k) * srcMatrix.at(k, col);
                }
            }
        }
        return result;
    }

    vec3 mat3::operator *(const vec3& srcVector) const {
        return vec3(
            at(0, 0) * srcVector.x + at(0, 1) * srcVector.y + at(0, 2) * srcVector.z,
            at(1, 0) * srcVector.x + at(1, 1) * srcVector.y + at(1, 2) * srcVector.z,
            at(2, 0) * srcVector.x + at(2, 1) * srcVector.y + at(2, 2) * srcVector.z
        );
    }

    mat3 mat3::operator +(const mat3& srcMatrix) const {
        mat3 result;
        for (int i = 0; i < 9; i++) {
            result.matrixData[i] = matrixData[i] + srcMatrix.matrixData[i];
        }
        return result;
    }

    float& mat3::at(int i, int j) {
        return matrixData[i + j * 3];
    }

    const float& mat3::at(int i, int j) const {
        return matrixData[i + j * 3];
    }

    float mat3::determinant() const {
        return at(0, 0) * (at(1, 1) * at(2, 2) - at(1, 2) * at(2, 1)) -
            at(0, 1) * (at(1, 0) * at(2, 2) - at(1, 2) * at(2, 0)) +
            at(0, 2) * (at(1, 0) * at(2, 1) - at(1, 1) * at(2, 0));
    }

    mat3 mat3::inverse() const {
        mat3 result;
        float det = determinant();
        float invDet = 1.0f / det;

        result.at(0, 0) = (at(1, 1) * at(2, 2) - at(1, 2) * at(2, 1)) * invDet;
        result.at(0, 1) = (at(0, 2) * at(2, 1) - at(0, 1) * at(2, 2)) * invDet;
        result.at(0, 2) = (at(0, 1) * at(1, 2) - at(0, 2) * at(1, 1)) * invDet;
        result.at(1, 0) = (at(1, 2) * at(2, 0) - at(1, 0) * at(2, 2)) * invDet;
        result.at(1, 1) = (at(0, 0) * at(2, 2) - at(0, 2) * at(2, 0)) * invDet;
        result.at(1, 2) = (at(0, 2) * at(1, 0) - at(0, 0) * at(1, 2)) * invDet;
        result.at(2, 0) = (at(1, 0) * at(2, 1) - at(1, 1) * at(2, 0)) * invDet;
        result.at(2, 1) = (at(0, 1) * at(2, 0) - at(0, 0) * at(2, 1)) * invDet;
        result.at(2, 2) = (at(0, 0) * at(1, 1) - at(0, 1) * at(1, 0)) * invDet;
        return result;
    }

    mat3 mat3::transpose() const {
        mat3 result;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result.matrixData[row * 3 + col] = matrixData[row + 3 * col];
            }
        }
        return result;
    }
}
