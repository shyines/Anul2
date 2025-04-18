package com.pt.a2.utils;

import com.pt.a2.model.SimulationData;

public class LogFileFactory {
    private static final String LOG_OUT_DIR_PATH_FORMAT = "D:\\Facultate\\Anul2\\Anul2\\Sem2\\TP\\Assignmets\\TP-2025-main\\TP-2025-main\\logs/%s/";
    private static final String LOG_FILE_NAME_FORMAT = "T%d_C%d_Q%d_A%s_S%s_%d.log";

    public static String getPathName(SimulationData data) {
        var unixTimestamp = System.currentTimeMillis() / 1000L;
        var outDirPath = String.format(LOG_OUT_DIR_PATH_FORMAT, data.selectionPolicy().toString());

        var logFileName = String.format(
                LOG_FILE_NAME_FORMAT, data.time(), data.clientCount(), data.qCount(), data.arrivalTimeInterval(), data.serviceTimeInterval(), unixTimestamp
        );

        return outDirPath + logFileName;
    }
}
