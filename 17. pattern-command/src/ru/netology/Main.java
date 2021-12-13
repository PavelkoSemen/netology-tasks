package ru.netology;

import ru.netology.frog.Frog;
import ru.netology.frogcommand.FrogCommand;
import ru.netology.frogcommand.FrogCommands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frog frog = new Frog();
        FrogCommand frogJump = null;
        List<FrogCommand> commands = new ArrayList<>();
        int curCommand = -1;
        while (true) {
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            if (command.equals("0")) {
                break;
            }
            if (command.charAt(0) == '+') {
                frogJump = FrogCommands.jumpRightCommand(frog, Integer.parseInt(command.substring(1)));
            }else if(command.charAt(0) == '-'){
                frogJump = FrogCommands.jumpLeftCommand(frog, Integer.parseInt(command.substring(1)));
            }

            switch (command) {
                case "<<":
                    if (curCommand < 0) {
                        System.out.println("Нечего отменять!");
                    } else {
                        commands.get(curCommand).undo();
                        curCommand--;
                    }
                    break;
                case ">>":
                    if (curCommand == commands.size() - 1) {
                        System.out.println("Нечего возвращать!");
                    } else {
                        curCommand++;
                        commands.get(curCommand).doit();
                    }
                    break;
                default:
                    if (curCommand != commands.size() - 1) {
                        while (curCommand < commands.size() - 1) {
                            System.out.println("тута");
                            commands.remove(commands.size() - 1);
                        }
                    }

                    if (frogJump == null) {
                        System.out.println("Неверная комманда");
                        continue;
                    }
                    curCommand++;
                    commands.add(frogJump);
                    frogJump.doit();
                    break;
            }
            System.out.println(curCommand);

            frog.showPosition();
        }
    }
}
