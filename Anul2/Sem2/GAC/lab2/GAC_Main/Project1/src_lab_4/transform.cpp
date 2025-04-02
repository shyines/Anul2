#include "transform.h"

namespace egc {
	mat3 translate(const vec2 translateArray) {
		mat3 b = mat3();
		b.at(1, 3) = translateArray.x;
		b.at(2, 3) = translateArray.y;

		return b;
	}

	mat3 translate(float tx, float ty) {
		mat3 b = mat3();
		b.at(1, 3) = tx;
		b.at(2, 3) = ty;

		return b;
	}

	mat3 scale(const vec2 scaleArray) {
		mat3 b = mat3();
		b.at(1, 1) = scaleArray.x;
		b.at(2, 2) = scaleArray.y;

		return b;
	}

	mat3 scale(float sx, float sy) {
		mat3 b = mat3();
		b.at(1, 1) = sx;
		b.at(2, 2) = sy;

		return b;
	}

	mat4 translate(const vec3 translateArray) {
		mat4 b = mat4();
		b.at(1, 4) = translateArray.x;
		b.at(2, 4) = translateArray.y;
		b.at(3, 4) = translateArray.z;

		return b;
	}

	mat4 translate(float tx, float ty, float tz) {
		mat4 b = mat4();
		b.at(1, 4) = tx;
		b.at(2, 4) = ty;
		b.at(3, 4) = tz;

		return b;
	}

	mat4 scale(const vec3 scaleArray) {
		mat4 b = mat4();
		b.at(1, 1) = scaleArray.x;
		b.at(2, 2) = scaleArray.y;
		b.at(3, 3) = scaleArray.z;

		return b;
	}

	mat4 scale(float sx, float sy, float sz) {
		mat4 b = mat4();
		b.at(1, 1) = sx;
		b.at(2, 2) = sy;
		b.at(3, 3) = sz;

		return b;
	}
}