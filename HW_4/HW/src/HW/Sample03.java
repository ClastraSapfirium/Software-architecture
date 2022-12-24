package HW;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Sample03 {

    /* TODO: ДОМАШНЯЯ РАБОТА
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     *
     * 4,5,6,7,8 - необязательные, опциональные задания.
     *
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы. /n
     * 6.  Реализовать наследование. /n
     * 7.  Выявить компоненты. /n
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей. /n
     * */
    public static void main(String[] args) {

        Core core = new Core();

        MobileApp mobileApp = new MobileApp(core.getCustomerProvider(), core.getTicketProvider());
        mobileApp.searchTicket(new Date());
        mobileApp.buyTicket("1000000000000033");
        mobileApp.buyTicket("1000000000000033");
        mobileApp.buyTicket("1000000000000033");
        mobileApp.searchTicket(new Date());

    }

}
/*
 * идент-я пользователя
 */

class Customer{

    private static int counter;
    private final int id;

    private Collection<Ticket> tickets;

    {
        id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

}

/*
 * идент-я билета
 */

class Ticket{

    private int id;
    private int customerId;
    private Date date;
    private String qrcode;

    private boolean enable = true;

    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }
}

/*
 * ядро программы
 */
class Core{

    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core(){
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(database, paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

}

/*
 * База данных
 */

class Database{

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>();

    private Collection<Customer> customers = new ArrayList<>();

    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    /**
     * Получить актуальную стоимость билета
     * @return
     */

    public double getTicketAmount(){
        return 60;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     */

    public int createTicketOrder(int clientId){
        return ++counter;
    }

}

/**
 * Мобильное приложение
 */

class MobileApp{

    private  Customer customer;
    private final TicketProvider ticketProvider;

    public MobileApp(CustomerProvider customerProvider, TicketProvider ticketProvider){
        this.ticketProvider = ticketProvider;
        customer = customerProvider.getCustomer("login", "password");
    }


    public void searchTicket(Date date){
        customer.setTickets(ticketProvider.searchTicket(customer.getId(), date));
    }

    public boolean buyTicket(String cardNo){
        return ticketProvider.buyTicket(customer.getId(), cardNo);
    }

}

/**
 * Автобусная станция
 */


class BusStation{

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider){
        this.ticketProvider = ticketProvider;
    }

    public boolean checkTicket(String qrCode){
        return ticketProvider.checkTicket(qrCode);
    }

}

/*
 * супермодуль получения пользователя
 */

class CustomerProvider{

    private Database database;

    public CustomerProvider(Database database){
        this.database = database;
    }

    public Customer getCustomer(String login, String password){
        // ... проверка логина и пароля
        Boolean match = true;
        if (match == true){
            return database.getCustomers().stream().findFirst().get();
        }
        else{
            System.err.println("Отказано в доступе");
            return null;
        }
    }
}

/*
 * супермодуль получения билета
 */

class TicketProvider{

    private Database database;
    private PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider){
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    /**
     * Поиск билетов
     */

    public Collection<Ticket> searchTicket(int clientId, Date date){

        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getCustomerId() == clientId || ticket.getDate().equals(date))
                tickets.add(ticket);
        }
        return tickets;

    }

    /**
     * Покупка билета
     */

    public boolean buyTicket(int clientId, String cardNo){

        double amount = database.getTicketAmount();
        int orderId =  database.createTicketOrder(clientId);
        String payment = "match";
        return paymentProvider.buy(orderId, cardNo, amount, payment);
    }

    /**
     * Проверка билетика
     */

    public boolean checkTicket(String qrcode){
        for (Ticket ticket: database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)){
                ticket.setEnable(false);
                // Save database ...
                return true;
            }
        }
        return false;
    }

}

/**
 * Платежный шлюз
 */

class PaymentProvider{

    /*
     * Проверка оплаты билета
     */

    public boolean buy(int orderId, String cardNo, double amount, String payment){
        if (payment == "match"){
            return true;
        }
        else{
            return false;
        }
    }

}

/*
 * Процессинговая компания
 */

class ProcessingCompany{

    private Collection<Bank> banks = new ArrayList<>();

}

/*
 * Банки (банки владельцев банковских карт)
 */

class Bank{
    
    private int Card_id;// номер карты
    private int customerName; // Ф,И,О gjkmpjdfntkz rfhns
    private Date date; //срок дейсвия карты
    private String CardModel; // Модель карты (visa, MasterCard и т.п.)

    private boolean enable = true; // Разрешение на создание карты

    public int getCard_Id() {
        return Card_id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getCardModel() {
        return CardModel;
    }

    public int getCustomerName() {
        return customerName;
    }

    public Date getDate() {
        return date;
    }
}