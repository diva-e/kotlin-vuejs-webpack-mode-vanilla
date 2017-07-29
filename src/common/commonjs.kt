package runtime.wrappers

// We can't support vue files for now. So we need to load html and css files with require
external fun require(module: String): dynamic