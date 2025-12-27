package scenario;

import characters.*;
import characters.base.*;
import enums.MentalState;
import flat_and_rooms.*;
import items.*;

import sound.Sound;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class UncleArrivalScenario {

    /* -------- квартиры и площадка -------- */
    private final Room       kidsRoom;
    private final Room       kitchen;
    private final Hallway    hallway;       // внутренняя прихожая
    private final FlatRoom   landing;       // лестничная площадка (за дверью)

    /* -------- персонажи -------- */
    private final Kid         kid;
    private final Karlson     karlson;
    private final FrekenBok   freken;
    private final UncleJulius uncle;
    private final Animal      bimbo;

    private final Random rnd = new Random();

    private final ToyPistol pistol;
    private final Watercan can;


    public UncleArrivalScenario() {

        /* -----------------------------------------------------------
         * 1. СТРОИМ КВАРТИРУ + ЛЕСТНИЧНУЮ ПЛОЩАДКУ
         * ----------------------------------------------------------- */
        kidsRoom = new Room(new ArrayList<characters.base.Character>(), "Детская комната", new ArrayList<FlatRoom>(), new ArrayList<Animal>(), new Bed(false, null));   // детская с кроватью
        kitchen  = new Room(new ArrayList<characters.base.Character>(), "Кухня", new ArrayList<FlatRoom>(), new ArrayList<Animal>(), null);                       // кухня без кровати
        hallway  = new Hallway(new ArrayList<characters.base.Character>(), "Коридор", new ArrayList<FlatRoom>(), new ArrayList<Animal>());                    // внутренняя прихожая
        landing  = new Hallway(new ArrayList<characters.base.Character>(), "Лестничная клетка", new ArrayList<FlatRoom>(), new ArrayList<Animal>(), hallway.getToDoor());          // площадка за дверью

        // соединяем комнаты
        connect(kidsRoom , hallway);
        connect(kitchen  , hallway);
        connect(hallway  , landing);


        /* -----------------------------------------------------------
         * 2. СОЗДАЁМ ПЕРСОНАЖЕЙ
         * ----------------------------------------------------------- */
        kid = new Kid("Малыш", "Маленький мальчик", kidsRoom);
        karlson = new Karlson("Карлсон", "Мальчик с пропеллером (в полном расцвете сил)", kidsRoom);
        freken = new FrekenBok("Фрекен Бок", "Няня", kitchen);
        uncle = new UncleJulius("Дядя Юлиус", "Дядя с чемоданами", landing);
        bimbo = new Animal("Бимбо", "Собака (гав гав)", kidsRoom);

        kidsRoom.setCharacters(new ArrayList<characters.base.Character>() {{
            add(kid); add(karlson);
        }});
        kitchen.setCharacters(new ArrayList<characters.base.Character>(){{add(freken);}});
        kitchen.setAnimals(new ArrayList<>(){{add(bimbo);}});
        landing.setCharacters(new ArrayList<characters.base.Character>(){{add(uncle);}});


        Suitcase suitcase = new Suitcase(landing, uncle,
                new ArrayList<>(), "дядин чемодан 1");
        Suitcase suitcase1 = new Suitcase(landing, uncle,
                new ArrayList<>(), "дядин чемодан 2");
        // Пистолет и лейка со случайным наполнением
        pistol = new ToyPistol(landing, uncle, true);
        can = new Watercan (landing, true);

        uncle.pickItem(suitcase);
        uncle.pickItem(suitcase1);

        karlson.pickItem(pistol);
        karlson.pickItem(can);
        karlson.getToBed();
    }

    /* ---------------------------------------------------------------
     *                           СЦЕНАРИЙ
     * --------------------------------------------------------------- */
    public void play() {

//        System.out.println("\n=== 1. ДЯДЯ НАЖИМАЕТ ЗВОНОК ===");
        // дядя, стоя на площадке, жмёт кнопку
        uncle.ring();



        if (true) {
            karlson.leaveBed();
            karlson.moveTo(hallway);
        }

        /* -------- Малыш открывает дверь -------- */
        System.out.println("\n=== 2. Малыш открывает дверь ===");
        kid.openHallwayDoor();

        /* -------- Юлиус входит в квартиру -------- */
        uncle.moveTo(hallway);


        if (hallway.getCharacters().contains(karlson)) {

            if (pistol.isFull()) {
                System.out.println("\n=== 3. БАХ! ===");
                karlson.shoot(uncle);
                if (rnd.nextInt(100) <= 70){
                    uncle.loseConscious();
                    kid.see(uncle);
                    freken.see(uncle);
                    bimbo.see(uncle);
                }
            }


            if (uncle.getMentalState() == MentalState.UNCONSCIOUS) {
                if (can.isFull()) {
                    System.out.println("\n=== 4. ЛЕЙКА  ===");

                    karlson.pourOnCharacter(uncle);

                    uncle.regainConscious();
                }
                else{
                    System.out.println("Дядя очнулся сам через некоторое время.");
                    uncle.regainConscious();
                }
            }
        }

        System.out.println("\n--- Сценарий окончен ---\n");
    }

    /* ---------------------------------------------------------------
     *                    ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ
     * --------------------------------------------------------------- */

    // соединяем две комнаты друг с другом (симметрично) без Map
    private void connect(FlatRoom a, FlatRoom b) {
        if (a.getConnectedRooms() == null) a.setConnectedRooms(new ArrayList<>());
        if (b.getConnectedRooms() == null) b.setConnectedRooms(new ArrayList<>());

        a.getConnectedRooms().add(b);
        b.getConnectedRooms().add(a);
    }

}