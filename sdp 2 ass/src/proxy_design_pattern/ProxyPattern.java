package proxy_design_pattern;

// Интерфейс для выполнения запросов к базе данных
interface DatabaseExecuter {
    void executeDatabase(String query) throws Exception;
}

// Реализация интерфейса DatabaseExecuter
class DatabaseExecuterImpl implements DatabaseExecuter {
    @Override
    public void executeDatabase(String query) throws Exception {
        System.out.println("Going to execute Query: " + query);
    }
}

// Прокси-класс для выполнения запросов к базе данных
class DatabaseExecuterProxy implements DatabaseExecuter {
    private boolean isAdmin;
    private DatabaseExecuterImpl realDatabaseExecuter;

    public DatabaseExecuterProxy(String name, String passwd) {
        if ("Admin".equals(name) && "Admin@123".equals(passwd)) {
            isAdmin = true; // Пользователь считается администратором, если имя и пароль совпадают.
        }
        realDatabaseExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception {
        if (isAdmin) {
            realDatabaseExecuter.executeDatabase(query);
        } else {
            if ("DELETE".equals(query)) {
                throw new Exception("DELETE not allowed for non-admin user");
            } else {
                realDatabaseExecuter.executeDatabase(query);
            }
        }
    }
}

public class ProxyPattern {
    public static void main(String[] args) throws Exception {
        // Пример использования паттерна Proxy
        // Создаем прокси-объекты для разных типов пользователей
        DatabaseExecuter nonAdminProxy = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        DatabaseExecuter adminProxy = new DatabaseExecuterProxy("Admin", "Admin@123");

        // Выполняем запросы
        nonAdminProxy.executeDatabase("DELETE");  // Запрос DELETE не разрешен для не-администратора.
        adminProxy.executeDatabase("DELETE");      // Запрос DELETE разрешен для администратора.
    }
}
