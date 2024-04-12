package com.dulat.inputs;

public class Validator {
    public static ErrorState validate(String s) {
        String[] args = s.split(" ");

        if (args.length == 0) return ErrorState.EMPTY_COMMAND_ERROR;
        if (s.equals("")) return ErrorState.EMPTY_COMMAND_ERROR;
        if (args[0].equals("create")) return validateCreateCommand(args);
        if (args[0].equals("delete")) return validateDeleteCommand(args);
        if (args[0].equals("rename")) return validateRenameCommand(args);
        if (args[0].equals("copy")) return validateCopyCommand(args);
        if (args[0].equals("help")) return ErrorState.NO_ERROR;
        if (args[0].equals("quit")) return ErrorState.NO_ERROR;

        return ErrorState.INCORRECT_COMMAND_NAME;
    }

    public static ErrorState validateCreateCommand(String[] args) {
        if (args.length < 3) return ErrorState.FEW_ARGUMENTS_ERROR;
        if (args.length > 3) return ErrorState.TOO_MANY_ARGUMENTS_ERROR;
        if (!args[1].contains(".")) return ErrorState.INCORRECT_FILE_NAME;
        return ErrorState.NO_ERROR;
    }

    public static ErrorState validateDeleteCommand(String[] args) {
        if (args.length < 3) return ErrorState.FEW_ARGUMENTS_ERROR;
        if (args.length > 3) return ErrorState.TOO_MANY_ARGUMENTS_ERROR;
        if (!args[1].contains(".")) return ErrorState.INCORRECT_FILE_NAME;
        return ErrorState.NO_ERROR;
    }

    public static ErrorState validateRenameCommand(String[] args) {
        if (args.length < 4) return ErrorState.FEW_ARGUMENTS_ERROR;
        if (args.length > 4) return ErrorState.TOO_MANY_ARGUMENTS_ERROR;
        if (!args[1].contains(".")) return ErrorState.INCORRECT_FILE_NAME;
        return ErrorState.NO_ERROR;
    }

    public static ErrorState validateCopyCommand(String[] args) {
        if (args.length < 4) return ErrorState.FEW_ARGUMENTS_ERROR;
        if (args.length > 4) return ErrorState.TOO_MANY_ARGUMENTS_ERROR;
        if (!args[1].contains(".")) return ErrorState.INCORRECT_FILE_NAME;
        return ErrorState.NO_ERROR;
    }
}
