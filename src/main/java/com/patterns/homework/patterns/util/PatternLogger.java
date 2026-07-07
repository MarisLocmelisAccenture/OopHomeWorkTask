package com.patterns.homework.patterns.util;

public class PatternLogger {
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public static void printSection(String title) {
        System.out.println();
        System.out.println(BOLD + "╔" + "═".repeat(78) + "╗" + RESET);
        System.out.println(BOLD + "║ " + CYAN + title.toUpperCase() + RESET + BOLD + " ".repeat(Math.max(0, 76 - title.length())) + "║" + RESET);
        System.out.println(BOLD + "╚" + "═".repeat(78) + "╝" + RESET);
    }

    public static void printPatternInfo(String patternName, String description) {
        System.out.println(BLUE + "🔷 Pattern: " + BOLD + patternName + RESET);
        System.out.println(BLUE + "   Description: " + description + RESET);
        System.out.println();
    }

    public static void printAction(String actor, String action) {
        System.out.println(GREEN + "  ✓ " + actor + ": " + action + RESET);
    }

    public static void printMediation(String message) {
        System.out.println(YELLOW + "  ↔ [MEDIATOR] " + message + RESET);
    }

    public static void printObservation(String message) {
        System.out.println(PURPLE + "  👁 [OBSERVER] " + message + RESET);
    }

    public static void printDecoration(String message) {
        System.out.println(PURPLE + "  🎭 [DECORATOR] " + message + RESET);
    }

    public static void printFactoryCreation(String type, String content) {
        System.out.println(CYAN + "  ⚙ [FACTORY] Created " + type + ": \"" + content + "\"" + RESET);
    }

    public static void printReceived(String receiver, String content, String messageType) {
        System.out.println(GREEN + "  ← " + receiver + " received (" + messageType + "): \"" + content + "\"" + RESET);
    }

    public static void printSent(String sender, String content) {
        System.out.println(BLUE + "  → " + sender + " sent: \"" + content + "\"" + RESET);
    }

    public static void printInfo(String message) {
        System.out.println(CYAN + message + RESET);
    }

    public static void printWarning(String message) {
        System.out.println(YELLOW + "⚠ " + message + RESET);
    }
}
