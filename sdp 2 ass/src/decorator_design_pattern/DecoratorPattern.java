package decorator_design_pattern;

// Интерфейс Skirt определяет основные функции для юбки
interface Skirt {
    void assemble();
}

// Конкретный класс, представляющий основные характеристики юбки
class BasicSkirt implements Skirt {
    @Override
    public void assemble() {
        System.out.println("Basic Skirt Features");
    }
}

// Базовый класс декоратора, от которого наследуются другие декораторы
class SkirtDecorator implements Skirt {
    protected Skirt skirt;

    public SkirtDecorator(Skirt skirt) {
        this.skirt = skirt;
    }

    @Override
    public void assemble() {
        skirt.assemble();
    }
}

// Конкретный декоратор, добавляющий характеристики повседневной одежды
class CasualSkirt extends SkirtDecorator {
    public CasualSkirt(Skirt skirt) {
        super(skirt);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Skirt Features");
    }
}

// Конкретный декоратор, добавляющий характеристики спортивной одежды
class SportySkirt extends SkirtDecorator {
    public SportySkirt(Skirt skirt) {
        super(skirt);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Skirt Features");
    }
}

// Конкретный декоратор, добавляющий характеристики праздничной одежды
class FancySkirt extends SkirtDecorator {
    public FancySkirt(Skirt skirt) {
        super(skirt);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Skirt Features");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Создание и декорирование юбок с различными характеристиками
        Skirt sportySkirt = new SportySkirt(new BasicSkirt());
        sportySkirt.assemble();
        System.out.println();

        Skirt fancySkirt = new FancySkirt(new BasicSkirt());
        fancySkirt.assemble();
        System.out.println();

        Skirt casualSkirt = new CasualSkirt(new BasicSkirt());
        casualSkirt.assemble();
        System.out.println();

        Skirt sportyFancySkirt = new SportySkirt(new FancySkirt(new BasicSkirt()));
        sportyFancySkirt.assemble();
        System.out.println();

        Skirt casualFancySkirt = new CasualSkirt(new FancySkirt(new BasicSkirt()));
        casualFancySkirt.assemble();
    }
}
