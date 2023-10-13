package facade_design_pattern;

import java.sql.Driver;

// Класс, представляющий операции в браузере Firefox
class Firefox {
    public static Driver getFirefoxDriver() {
        return null; // Симуляция получения драйвера для Firefox
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Генерация HTML-отчета для драйвера Firefox");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Генерация JUnit-отчета для драйвера Firefox");
    }
}

// Класс, представляющий операции в браузере Chrome
class Chrome {
    public static Driver getChromeDriver() {
        return null; // Симуляция получения драйвера для Chrome
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("Генерация HTML-отчета для драйвера Chrome");
    }

    public static void generateJUnitReport(String test, Driver driver) {
        System.out.println("Генерация JUnit-отчета для драйвера Chrome");
    }
}

// Фасадный класс, упрощающий генерацию отчетов для разных браузеров и форматов
class WebExplorerHelperFacade {
    public static void generateReports(String browser, String reportType, String test) {
        Driver driver = null;

        // Определение браузера (Firefox или Chrome)
        switch (browser) {
            case "firefox":
                driver = Firefox.getFirefoxDriver();
                switch (reportType) {
                    case "html":
                        Firefox.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Firefox.generateJUnitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (reportType) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJUnitReport(test, driver);
                        break;
                }
        }
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        String test = "ПроверкаНаличияЭлемента";

        // Используем фасад для генерации отчетов в разных веб-браузерах и форматах отчетов
        WebExplorerHelperFacade.generateReports("firefox", "html", test);
        WebExplorerHelperFacade.generateReports("firefox", "junit", test);
        WebExplorerHelperFacade.generateReports("chrome", "html", test);
        WebExplorerHelperFacade.generateReports("chrome", "junit", test);
    }
}
