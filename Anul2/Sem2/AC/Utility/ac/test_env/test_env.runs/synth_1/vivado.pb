
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
create_project: 2

00:00:082

00:00:092	
455.5202	
184.555Z17-268h px� 
�
Command: %s
1870*	planAhead2�
�read_checkpoint -auto_incremental -incremental D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/utils_1/imports/synth_1/saqwdf.dcpZ12-2866h px� 
�
;Read reference checkpoint from %s for incremental synthesis3154*	planAhead2g
eD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/utils_1/imports/synth_1/saqwdf.dcpZ12-5825h px� 
T
-Please ensure there are no constraint changes3725*	planAheadZ12-7989h px� 
a
Command: %s
53*	vivadotcl20
.synth_design -top saqwdf -part xc7a35tcpg236-1Z4-113h px� 
:
Starting synth_design
149*	vivadotclZ4-321h px� 
z
@Attempting to get a license for feature '%s' and/or device '%s'
308*common2
	Synthesis2	
xc7a35tZ17-347h px� 
j
0Got license for feature '%s' and/or device '%s'
310*common2
	Synthesis2	
xc7a35tZ17-349h px� 
�
^The reference checkpoint is from an old version of Vivado; A full resynthesis flow will be run653*	vivadotclZ4-1809h px� 
D
Loading part %s157*device2
xc7a35tcpg236-1Z21-403h px� 

VNo compile time benefit to using incremental synthesis; A full resynthesis will be run2353*designutilsZ20-5440h px� 
�
�Flow is switching to default flow due to incremental criteria not met. If you would like to alter this behaviour and have the flow terminate instead, please set the following parameter config_implementation {autoIncr.Synth.RejectBehavior Terminate}2229*designutilsZ20-4379h px� 
o
HMultithreading enabled for synth_design using a maximum of %s processes.4828*oasys2
2Z8-7079h px� 
a
?Launching helper process for spawning children vivado processes4827*oasysZ8-7078h px� 
N
#Helper process launched with PID %s4824*oasys2
11664Z8-7075h px� 
�
%s*synth2{
yStarting RTL Elaboration : Time (s): cpu = 00:00:11 ; elapsed = 00:00:12 . Memory (MB): peak = 1291.242 ; gain = 440.121
h px� 
�
synthesizing module '%s'638*oasys2
saqwdf2a
]D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/test_env.vhd2
458@Z8-638h px� 
�
Hmodule '%s' declared at '%s:%s' bound to instance '%s' of component '%s'3392*oasys2
MPG2Z
XD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/MPG.vhd2
362
P12
MPG2a
]D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/test_env.vhd2
578@Z8-3491h px� 
�
synthesizing module '%s'638*oasys2
MPG2\
XD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/MPG.vhd2
428@Z8-638h px� 
�
%done synthesizing module '%s' (%s#%s)256*oasys2
MPG2
02
12\
XD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/MPG.vhd2
428@Z8-256h px� 
�
Esignal '%s' is read in the process but is not in the sensitivity list614*oasys2
count2a
]D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/test_env.vhd2
588@Z8-614h px� 
�
%done synthesizing module '%s' (%s#%s)256*oasys2
saqwdf2
02
12a
]D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/test_env.vhd2
458@Z8-256h px� 
�
0Net %s in module/entity %s does not have driver.3422*oasys2
an2
saqwdf2a
]D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/test_env.vhd2
418@Z8-3848h px� 
�
0Net %s in module/entity %s does not have driver.3422*oasys2
cat2
saqwdf2a
]D:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/sources_1/new/test_env.vhd2
428@Z8-3848h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[3]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[2]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[1]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[0]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[6]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[5]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[4]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[3]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[2]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[1]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[0]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[4]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[3]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[2]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[1]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[15]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[14]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[13]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[12]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[11]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[10]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[9]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[8]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[7]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[6]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[5]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[4]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[3]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[2]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[1]2
saqwdfZ8-7129h px� 
�
%s*synth2{
yFinished RTL Elaboration : Time (s): cpu = 00:00:15 ; elapsed = 00:00:16 . Memory (MB): peak = 1397.785 ; gain = 546.664
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
;
%s
*synth2#
!Start Handling Custom Attributes
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Handling Custom Attributes : Time (s): cpu = 00:00:15 ; elapsed = 00:00:16 . Memory (MB): peak = 1397.785 ; gain = 546.664
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished RTL Optimization Phase 1 : Time (s): cpu = 00:00:15 ; elapsed = 00:00:16 . Memory (MB): peak = 1397.785 ; gain = 546.664
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
Netlist sorting complete. 2

00:00:002
00:00:00.0022

1397.7852
0.000Z17-268h px� 
K
)Preparing netlist for logic optimization
349*projectZ1-570h px� 
>

Processing XDC Constraints
244*projectZ1-262h px� 
=
Initializing timing engine
348*projectZ1-569h px� 
�
Parsing XDC File [%s]
179*designutils2q
mD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/constrs_1/imports/test_env/constraints.xdc8Z20-179h px� 
�
Finished Parsing XDC File [%s]
178*designutils2q
mD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/constrs_1/imports/test_env/constraints.xdc8Z20-178h px� 
�
�Implementation specific constraints were found while reading constraint file [%s]. These constraints will be ignored for synthesis but will be used in implementation. Impacted constraints are listed in the file [%s].
233*project2o
mD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.srcs/constrs_1/imports/test_env/constraints.xdc2
.Xil/saqwdf_propImpl.xdcZ1-236h px� 
H
&Completed Processing XDC Constraints

245*projectZ1-263h px� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
Netlist sorting complete. 2

00:00:002

00:00:002

1442.7232
0.000Z17-268h px� 
l
!Unisim Transformation Summary:
%s111*project2'
%No Unisim elements were transformed.
Z1-111h px� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2"
 Constraint Validation Runtime : 2

00:00:002
00:00:00.0042

1442.7232
0.000Z17-268h px� 

VNo compile time benefit to using incremental synthesis; A full resynthesis will be run2353*designutilsZ20-5440h px� 
�
�Flow is switching to default flow due to incremental criteria not met. If you would like to alter this behaviour and have the flow terminate instead, please set the following parameter config_implementation {autoIncr.Synth.RejectBehavior Terminate}2229*designutilsZ20-4379h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
Finished Constraint Validation : Time (s): cpu = 00:00:24 ; elapsed = 00:00:26 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
D
%s
*synth2,
*Start Loading Part and Timing Information
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
8
%s
*synth2 
Loading part: xc7a35tcpg236-1
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Loading Part and Timing Information : Time (s): cpu = 00:00:24 ; elapsed = 00:00:26 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
H
%s
*synth20
.Start Applying 'set_property' XDC Constraints
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished applying 'set_property' XDC Constraints : Time (s): cpu = 00:00:25 ; elapsed = 00:00:26 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished RTL Optimization Phase 2 : Time (s): cpu = 00:00:25 ; elapsed = 00:00:27 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
:
%s
*synth2"
 Start RTL Component Statistics 
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
9
%s
*synth2!
Detailed RTL Component Info : 
h p
x
� 
+
%s
*synth2
+---Registers : 
h p
x
� 
H
%s
*synth20
.	                1 Bit    Registers := 3     
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
=
%s
*synth2%
#Finished RTL Component Statistics 
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
6
%s
*synth2
Start Part Resource Summary
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
p
%s
*synth2X
VPart Resources:
DSPs: 90 (col length:60)
BRAMs: 100 (col length: RAMB18 60 RAMB36 30)
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
9
%s
*synth2!
Finished Part Resource Summary
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
E
%s
*synth2-
+Start Cross Boundary and Area Optimization
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
H
&Parallel synthesis criteria is not met4829*oasysZ8-7080h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[3]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[2]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[1]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
an[0]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[6]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[5]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[4]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[3]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[2]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[1]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
cat[0]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[4]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[3]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[2]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
btn[1]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[15]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[14]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[13]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[12]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[11]2
saqwdfZ8-7129h px� 
o
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[10]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[9]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[8]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[7]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[6]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[5]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[4]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[3]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[2]2
saqwdfZ8-7129h px� 
n
9Port %s in module %s is either unconnected or has no load4866*oasys2
sw[1]2
saqwdfZ8-7129h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Cross Boundary and Area Optimization : Time (s): cpu = 00:00:27 ; elapsed = 00:00:29 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
@
%s
*synth2(
&Start Applying XDC Timing Constraints
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Applying XDC Timing Constraints : Time (s): cpu = 00:00:33 ; elapsed = 00:00:35 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
4
%s
*synth2
Start Timing Optimization
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2
}Finished Timing Optimization : Time (s): cpu = 00:00:33 ; elapsed = 00:00:35 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
3
%s
*synth2
Start Technology Mapping
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2~
|Finished Technology Mapping : Time (s): cpu = 00:00:33 ; elapsed = 00:00:35 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
-
%s
*synth2
Start IO Insertion
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
?
%s
*synth2'
%Start Flattening Before IO Insertion
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
B
%s
*synth2*
(Finished Flattening Before IO Insertion
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
6
%s
*synth2
Start Final Netlist Cleanup
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
9
%s
*synth2!
Finished Final Netlist Cleanup
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2x
vFinished IO Insertion : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
=
%s
*synth2%
#Start Renaming Generated Instances
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Renaming Generated Instances : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
:
%s
*synth2"
 Start Rebuilding User Hierarchy
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Rebuilding User Hierarchy : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
9
%s
*synth2!
Start Renaming Generated Ports
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Renaming Generated Ports : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
;
%s
*synth2#
!Start Handling Custom Attributes
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Handling Custom Attributes : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
8
%s
*synth2 
Start Renaming Generated Nets
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Renaming Generated Nets : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
9
%s
*synth2!
Start Writing Synthesis Report
h p
x
� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
/
%s
*synth2

Report BlackBoxes: 
h p
x
� 
8
%s
*synth2 
+-+--------------+----------+
h p
x
� 
8
%s
*synth2 
| |BlackBox name |Instances |
h p
x
� 
8
%s
*synth2 
+-+--------------+----------+
h p
x
� 
8
%s
*synth2 
+-+--------------+----------+
h p
x
� 
/
%s*synth2

Report Cell Usage: 
h px� 
2
%s*synth2
+------+-------+------+
h px� 
2
%s*synth2
|      |Cell   |Count |
h px� 
2
%s*synth2
+------+-------+------+
h px� 
2
%s*synth2
|1     |BUFG   |     1|
h px� 
2
%s*synth2
|2     |CARRY4 |     8|
h px� 
2
%s*synth2
|3     |LUT1   |    16|
h px� 
2
%s*synth2
|4     |LUT2   |    17|
h px� 
2
%s*synth2
|5     |LUT6   |     3|
h px� 
2
%s*synth2
|6     |FDRE   |    35|
h px� 
2
%s*synth2
|7     |IBUF   |     3|
h px� 
2
%s*synth2
|8     |OBUF   |    16|
h px� 
2
%s*synth2
|9     |OBUFT  |    11|
h px� 
2
%s*synth2
+------+-------+------+
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
�
%s*synth2�
�Finished Writing Synthesis Report : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h px� 
l
%s
*synth2T
R---------------------------------------------------------------------------------
h p
x
� 
a
%s
*synth2I
GSynthesis finished with 0 errors, 0 critical warnings and 31 warnings.
h p
x
� 
�
%s
*synth2�
Synthesis Optimization Runtime : Time (s): cpu = 00:00:22 ; elapsed = 00:00:38 . Memory (MB): peak = 1442.723 ; gain = 546.664
h p
x
� 
�
%s
*synth2�
�Synthesis Optimization Complete : Time (s): cpu = 00:00:39 ; elapsed = 00:00:41 . Memory (MB): peak = 1442.723 ; gain = 591.602
h p
x
� 
B
 Translating synthesized netlist
350*projectZ1-571h px� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
Netlist sorting complete. 2

00:00:002
00:00:00.0012

1442.7232
0.000Z17-268h px� 
S
-Analyzing %s Unisim elements for replacement
17*netlist2
8Z29-17h px� 
X
2Unisim Transformation completed in %s CPU seconds
28*netlist2
0Z29-28h px� 
K
)Preparing netlist for logic optimization
349*projectZ1-570h px� 
Q
)Pushed %s inverter(s) to %s load pin(s).
98*opt2
02
0Z31-138h px� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
Netlist sorting complete. 2

00:00:002
00:00:00.0012

1442.7232
0.000Z17-268h px� 
l
!Unisim Transformation Summary:
%s111*project2'
%No Unisim elements were transformed.
Z1-111h px� 
V
%Synth Design complete | Checksum: %s
562*	vivadotcl2

bf228ff1Z4-1430h px� 
C
Releasing license: %s
83*common2
	SynthesisZ17-83h px� 

G%s Infos, %s Warnings, %s Critical Warnings and %s Errors encountered.
28*	vivadotcl2
262
652
02
0Z4-41h px� 
L
%s completed successfully
29*	vivadotcl2
synth_designZ4-42h px� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
synth_design: 2

00:00:492

00:00:542

1442.7232	
984.242Z17-268h px� 
�
I%sTime (s): cpu = %s ; elapsed = %s . Memory (MB): peak = %s ; gain = %s
268*common2
Write ShapeDB Complete: 2

00:00:002
00:00:00.0022

1442.7232
0.000Z17-268h px� 
�
 The %s '%s' has been generated.
621*common2

checkpoint2W
UD:/Facultate/Anul2/Anul2/Sem2/AC/Utility/ac/test_env/test_env.runs/synth_1/saqwdf.dcpZ17-1381h px� 
�
%s4*runtcl2d
bExecuting : report_utilization -file saqwdf_utilization_synth.rpt -pb saqwdf_utilization_synth.pb
h px� 
\
Exiting %s at %s...
206*common2
Vivado2
Mon Mar 10 18:19:54 2025Z17-206h px� 


End Record