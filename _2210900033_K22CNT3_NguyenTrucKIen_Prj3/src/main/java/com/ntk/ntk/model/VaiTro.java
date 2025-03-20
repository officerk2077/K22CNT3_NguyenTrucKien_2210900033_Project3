package com.ntk.ntk.model;

import java.util.HashMap;
import java.util.Map;

public enum VaiTro {
    ADMIN,
    USER;

    // Map to store case-insensitive mappings
    private static final Map<String, VaiTro> nameToValueMap = new HashMap<>();

    // Static block to populate the map
    static {
        for (VaiTro vaiTro : VaiTro.values()) {
            nameToValueMap.put(vaiTro.name().toLowerCase(), vaiTro);
        }
    }

    // Custom method to map a string to the enum (case-insensitive)
    public static VaiTro fromName(String name) {
        if (name == null) {
            return null;
        }
        VaiTro vaiTro = nameToValueMap.get(name.toLowerCase());
        if (vaiTro == null) {
            throw new IllegalArgumentException("No enum constant " + VaiTro.class.getCanonicalName() + " for name " + name);
        }
        return vaiTro;
    }
}