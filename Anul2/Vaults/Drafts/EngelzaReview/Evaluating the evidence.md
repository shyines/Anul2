
- Classical Toon-shader

1. The experiment:

	A total of 12 users participated in our experiment, among them 3 were skilled in drawing and/or animation and 9 were new to the field. The experiment is split into three different parts. The bouncing ball experiment (12 min), the walking cycle experiment (12 min), and the final interview (2 min).
	
	
	First Part - Bouncing Ball Experiment - a lamp post and the ball have been drawn and placed in the scene with respect to a grid patterned floor background, giving the illusion of depth. The user is asked to manually draw the shade of the ball with respect to the lamp post position, for each of the 11 frames of the animation cycle. The second task is to create the same scene, this time using our semi-automatic shading system.
	
	This experiment allows us to measure the effectiveness of our method on a simple scene (11 frames)
	
	
	Second Part -The user is asked to shade a human cartoon character in a walking cycle, as shown in [Fig. 21](https://www.sciencedirect.com/science/article/pii/S2590148619300032#fig0021). The participants are first asked to draw the shades manually on the first frame and then using our semi-automatic tool.
	
	This experiment allows us to measure the effectiveness of our method on a more complex scene.

	1.1 The Outcome
		1. For a simple scene such as the bouncing ball, our method takes longer on the first frame as there is an additional task consisting of positioning the light in the scene. However the propagation takes less than one second per frame. Manual shading was 198 s whereas it was only 55 s for the semi-automatic shading. ratio: 3,64.
		2. When asked, participants either preferred the semi automatic shading result over their drawing or stated that the two methods had comparable results.
		3. We also presented our work to a professional animator who stated that she would gladly use our tool for shading animations, but also digital still artwork.

2. The Results
	1. The Stomping Man (Petrović et al. [[11]](https://www.sciencedirect.com/science/article/pii/S2590148619300032#bib0011)
		- Toon Boom Harmony Pro
			- The software has the potential for creating very high quality normal maps and shading, however this is at the cost of simplicity and speed.
			- The sharp and smoothed results can be seen in [Fig. 24](https://www.sciencedirect.com/science/article/pii/S2590148619300032#fig0024) and took approximately 6–7 min.
		- TVPaint Pro
			- Provides an automatic and efficient shading tool called Toon Shading
			- The tool almost requires no user interaction
			- However, without pre-segmentation and layering of the body parts, inner parts like the arm in [Fig. 24](https://www.sciencedirect.com/science/article/pii/S2590148619300032#fig0024) are not shaded.
		- The Method
			- Qualitatively comparable to what can be achieved with state of the art methods in widely used professional animation software. This validates that our semi-automatic system is capable of creating plausible shades and self-shadows.
		- Conclusion
			- Our method is faster and easier to use than the one used in Harmony (even without pre-segmentation of body parts). TVPaint and our method can shade a drawn art at comparable speed.
	2. Three models
		- VS Artifact free 3D Model
			- Overly realistic in comparison to manual toon shading
			
			- The Tool
				- a less realistic shading, however it is closer to a traditional and appealing cartoon shading style.
		- VS A [3D reconstruction](https://www.sciencedirect.com/topics/computer-science/3d-reconstruction "Learn more about 3D reconstruction from ScienceDirect's AI-generated Topic Pages")
			- This model appears to contain enough, but not too many, [geometric details](https://www.sciencedirect.com/topics/computer-science/geometric-detail "Learn more about geometric details from ScienceDirect's AI-generated Topic Pages") for a nice toon shaded result. HOWEVER, relative depth order is known beforehand (preparations)
		- VS Fully automatic
			- Similar to the results of the 3D model in the first row, the shades generated using reconstructed normal map are in some places too complex for a nice toon shading result, and does not deal with shadows.
3. Is the experiment plausible? 
	- I believe that 12 participants were not enough and thus, the evidence is not fully plausible! Moreover, if they selected as many experienced artists as unexperienced, the experiment would have been more credible. On this matter, the Tool is not a really good documented tool.
4. Comparisons with other tools
	1. 