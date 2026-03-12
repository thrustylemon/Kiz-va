package com.kizva.model;

public class UserViews {
    // Level 1: Anyone can see (e.g., username)
    public static class Public {}

    // Level 2: Only compatible matches see this (e.g., compatibility score)
    public static class MatchTier extends Public {}

    // Level 3: Only the user themselves can see this (e.g., email, private goals)
    public static class Private extends MatchTier {}
}