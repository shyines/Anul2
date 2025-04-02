#include "clip.h"

namespace egc {

	std::vector<int> computeCSCode(std::vector<vec3> clipWindow, const vec3 p) {
		std::vector<int> code;
		//TO DO - compute the code for the point given as argument

		int xMin = clipWindow.at(2).x;
		int xMax = clipWindow.at(1).x;

		int yMin = clipWindow.at(1).y;
		int yMax = clipWindow.at(3).y;

		if (p.x <= xMin && p.y <= yMin) {
			code.push_back(1);
			code.push_back(0);
			code.push_back(0);
			code.push_back(1);
		}
		else if (p.x <= xMin && (p.y <= xMax && p.y >= xMin)) {

		}

		return code;
	}

	bool simpleRejection(std::vector<int> cod1, std::vector<int> cod2) {
		//TO DO - write the code to determine if the two input codes represent 
		//points in the SIMPLE REJECTION case

		return false;
	}

	bool simpleAcceptance(std::vector<int> cod1, std::vector<int> cod2) {
		//TO DO - write the code to determine if the two input codes represent 
		//points in the SIMPLE ACCEPTANCE case

		return false;
	}

	//function returns -1 if the line segment cannot be clipped
	int lineClip_CohenSutherland(std::vector<vec3> clipWindow, vec3& p1, vec3& p2) {
		//TO DO - implement the Cohen-Sutherland line clipping algorithm - consult the laboratory work

		return 0;
	}
}

