package es.ull.esit.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Small demo CLI app with a few utilities (besides Hello World).
 */
public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            runInteractive();
            return;
        }

        String cmd = args[0].toLowerCase();
        switch (cmd) {
            case "greet":
                LOGGER.log(Level.INFO, () -> greet(joinArgs(args, 1)));
                break;
            case "sum":
                LOGGER.log(Level.INFO, () -> "Sum: " + sumFromArgs(args, 1));
                break;
            case "reverse":
                LOGGER.log(Level.INFO, () -> reverse(joinArgs(args, 1)));
                break;
            case "prime":
                if (args.length < 2) {
                    LOGGER.info("Usage: prime <number>");
                    break;
                }
                    try {
                        long n = Long.parseLong(args[1]);
                        final long fn = n;
                        LOGGER.log(Level.INFO, () -> fn + (isPrime(fn) ? " is prime" : " is not prime"));
                    } catch (NumberFormatException e) {
                    LOGGER.log(Level.WARNING, "Invalid number: {0}", args[1]);
                }
                break;
            case "now":
                LOGGER.log(Level.INFO, App::now);
                break;
            case "help":
            default:
                printUsage();
                break;
        }
    }

    // Interactive menu when no args provided
    private static void runInteractive() {
        Scanner sc = new Scanner(System.in);
        LOGGER.info("Welcome to the small App demo (type 'help' to list commands).\n");
        while (true) {
            LOGGER.info("> ");
            String line = sc.nextLine();
            if (line == null) break;
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 0 || parts[0].isEmpty()) continue;
            String cmd = parts[0].toLowerCase();
            if (cmd.equals("exit") || cmd.equals("quit")) {
                LOGGER.info("Bye!");
                break;
            }
            switch (cmd) {
                case "help":
                    printUsage();
                    break;
                case "greet":
                    LOGGER.log(Level.INFO, () -> greet(joinArgs(parts, 1)));
                    break;
                case "sum":
                    try {
                        double s = sumFromStringArray(parts, 1);
                        LOGGER.log(Level.INFO, () -> "Sum: " + s);
                    } catch (NumberFormatException e) {
                        LOGGER.info("Provide numbers after 'sum', e.g. sum 1 2 3");
                    }
                    break;
                case "reverse":
                    LOGGER.log(Level.INFO, () -> reverse(joinArgs(parts, 1)));
                    break;
                case "prime":
                    if (parts.length < 2) {
                        LOGGER.info("Usage: prime <number>");
                        break;
                    }
                    try {
                        long n = Long.parseLong(parts[1]);
                        final long fn2 = n;
                        LOGGER.log(Level.INFO, () -> fn2 + (isPrime(fn2) ? " is prime" : " is not prime"));
                    } catch (NumberFormatException e) {
                        LOGGER.log(Level.WARNING, "Invalid number: {0}", parts[1]);
                    }
                    break;
                case "now":
                    LOGGER.log(Level.INFO, App::now);
                    break;
                default:
                    LOGGER.info("Unknown command. Type 'help' for available commands.");
                    break;
            }
        }
        sc.close();
    }

    private static void printUsage() {
        LOGGER.info("Usage (CLI): java -jar app.jar <command> [args]\\n" +
                "Commands:\n" +
                "  greet <name>      - Greet the given name.\n" +
                "  sum <n1> <n2>...  - Sum numbers and print result.\n" +
                "  reverse <text>    - Reverse the provided text.\n" +
                "  prime <n>         - Check if n is prime.\n" +
                "  now               - Print current date and time.\n" +
                "  help              - Show this message.\n" +
                "Interactive mode: run without args and use commands; 'exit' to quit.");
    }

    private static String greet(String name) {
        if (name == null || name.isEmpty()) return "Hello!";
        return "Hello, " + name + "!";
    }

    private static String joinArgs(String[] args, int start) {
        if (args == null || args.length <= start) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < args.length; i++) {
            if (i > start) sb.append(' ');
            sb.append(args[i]);
        }
        return sb.toString().trim();
    }

    private static double sumFromArgs(String[] args, int start) {
        double s = 0.0;
        for (int i = start; i < args.length; i++) {
            try {
                s += Double.parseDouble(args[i]);
            } catch (NumberFormatException e) {
                // ignore non-numeric values
            }
        }
        return s;
    }

    private static double sumFromStringArray(String[] arr, int start) {
        double s = 0.0;
        for (int i = start; i < arr.length; i++) s += Double.parseDouble(arr[i]);
        return s;
    }

    private static String reverse(String s) {
        if (s == null) return "";
        return new StringBuilder(s).reverse().toString();
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        long r = (long) Math.sqrt(n);
        for (long i = 3; i <= r; i += 2) if (n % i == 0) return false;
        return true;
    }

    private static String now() {
        LocalDateTime dt = LocalDateTime.now();
        return dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
