@REM TEST_CASE_1
call run.app.bat --policy q
call run.app.bat --policy t

@REM TEST_CASE_2
call run.app.bat -c 50 -q 5 --arrival-interval 2 40 --service-interval 1 7
call run.app.bat -c 50 -q 5 --arrival-interval 2 40 --service-interval 1 7 --policy t

@REM TEST_CASE_3
call run.app.bat -t 200 -c 1000 -q 20 --arrival-interval 10 100 --service-interval 3 9
call run.app.bat -t 200 -c 1000 -q 20 --arrival-interval 10 100 --service-interval 3 9 --policy t

