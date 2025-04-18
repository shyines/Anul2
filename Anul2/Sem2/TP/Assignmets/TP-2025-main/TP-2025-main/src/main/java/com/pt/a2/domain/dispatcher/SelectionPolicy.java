package com.pt.a2.domain.dispatcher;

public enum SelectionPolicy {
    SHORTEST_QUEUE,
    SHORTEST_TIME;

    public static SelectionPolicy fromString(String input) {
        return switch (input.toLowerCase()) {
            case "q", "shortest_queue" -> SHORTEST_QUEUE;
            case "t", "shortest_time" -> SHORTEST_TIME;
            default -> throw new IllegalArgumentException("Unknown selection policy: " + input);
        };
    }
}
