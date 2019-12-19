package Controller;

import java.util.ArrayList;

public class Controller
{
    private JDBC jdbc;

    public Controller()
    {
        jdbc=new JDBC();
    }

    public boolean addNewCorrespondent(String fio, String division_name, String position)
    {
        ArrayList<String> list=jdbc.select("SELECT FIO FROM workers WHERE FIO=\""+fio+"\"", JDBC.WORKERS);
        if(list.isEmpty())
        {
            String query="INSERT INTO workers VALUES (\""+fio+"\", \""+division_name+"\", \""+position+"\")";
            return jdbc.insert(query);
        }
        if(list.get(0).equals(fio))
            return true;
        return false;
    }

    public boolean addNewOrder(String number,
                               String date,
                               String content,
                               String head)
    {
        boolean answer=addNewCorrespondent(head.split("\n")[0], head.split("\n")[1], head.split("\n")[2]);
        if(answer==false)
            return answer;
        ArrayList<String> list=jdbc.select("SELECT orders.ORDER_ID FROM orders WHERE orders.ORDER_ID=\""+number+"\"", JDBC.ORDERS);
        if(list.isEmpty())
        {
            String query="INSERT INTO orders VALUES ("+number+", \""+date+"\", \""+content+"\", \""+head.split("\n")[0]+"\")";
            return jdbc.insert(query);
        }
        if(list.get(0).equals(number))
            return true;
        return false;
    }

    public boolean addNewOrderEvent(String number,
                               String event,
                               String responsibleMan,
                               String dateEvent,
                               String mark)
    {
        if (mark=="Да") mark="Y";
        if (mark=="Нет") mark="N";
        ArrayList<String> list2= jdbc.select("SELECT orders.ORDER_ID FROM orders WHERE orders.ORDER_ID=\""+number+"\"", JDBC.ORDERS);
        if(!list2.isEmpty()) {
            ArrayList<String> list = jdbc.select("SELECT ORDEREVENT, orderevents.ORDER_ID FROM orderevents WHERE ORDEREVENT=\"" + event + "\" AND orderevents.ORDER_ID=\"" + number + "\"", JDBC.ORDER_EVENTS);
            if (list.isEmpty()) {
                String query = "INSERT INTO orderevents VALUES (\"" + event + "\", " + number + ", \"" + dateEvent + "\", \"" + mark + "\", \"" + responsibleMan + "\")";
                return jdbc.insert(query);
            }
            if (list.get(0).equals(event))
                return true;
            return false;
        }
        return false;
    }

    public String[] getListCorrespondents()
    {
        ArrayList<String> arrayList=jdbc.select("SELECT FIO FROM workers", JDBC.WORKERS);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public String[] getListCorrespondents(String dateEvent)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT orders.DATE_OF_ADOPTION, orderevents.ORDEREVENT, orderevents.mark, orderevents.DATE_OF_FINISHING, " +
                "orderevents.FIO, workers.POSITION, workers.DIVISION_NAME FROM ((orderevents INNER JOIN orders USING (ORDER_ID)) " +
                "INNER JOIN workers ON workers.FIO=orderevents.FIO) WHERE orderevents.mark='N' AND DATE_OF_FINISHING<=\""+dateEvent+"\"", JDBC.CRAFT_TABLE);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public ArrayList<String> getInformationAboutCorr(String fio)
    {
        ArrayList<String> list=jdbc.select("SELECT * FROM workers WHERE FIO=\""+fio+"\"", JDBC.WORKERS_SELECTED_ALL);;
        return list;
    }

    public ArrayList<String> getInformationAboutOrder(String ID)
    {
        ArrayList<String> list=jdbc.select("SELECT * FROM orders WHERE orders.ORDER_ID=\""+ID+"\"", JDBC.ORDERS_SELECTED_ALL);
        System.out.println(list);
        ArrayList<String> correspondent=getInformationAboutCorr(list.get(3));
        if(correspondent.isEmpty())
            return new ArrayList<String>();//временно.
        System.out.println(correspondent);
        list.add(3, correspondent.get(0)+"\n"+correspondent.get(2)+"\n"+correspondent.get(1));
        return list;
    }

    public ArrayList<String> getInformationAboutEvent(String ORDEREVENT)
    {
        ArrayList<String> list=jdbc.select("SELECT ORDEREVENT, DATE_OF_FINISHING, MARK, FIO FROM orderevents WHERE ORDEREVENT=\""+ORDEREVENT+"\"", +JDBC.ORDER_EVENT_SELECTED_ALL);
        System.out.println(list);
        return list;
    }

    public boolean changeCorrespondent(String oldfio, String fio, String division_name, String position)
    {
        boolean answer=jdbc.update("UPDATE workers SET FIO=\""+fio+"\", DIVISION_NAME=\""+
                                    division_name+"\", POSITION=\""+position+"\" WHERE FIO=\""+oldfio+"\"");
        return answer;
    }

    public boolean changeOrder(String number,
                               String date,
                               String content,
                               String head,
                               String event,
                               String responsibleMan,
                               String dateEvent,
                               String mark)
    {
        if(getInformationAboutCorr(head).isEmpty())
            return false;
        boolean answer=jdbc.update("UPDATE orders SET DATE_OF_ADOPTION=\""+
                                    date+"\", CONTENT=\""+
                                    content+"\", FIO=\""+
                                    head+"\" WHERE orders.ORDER_ID="+
                                    number);
        if(answer==false)
            return answer;
        System.out.println("UPDATE orderevents SET ORDEREVENT=\"" +
                event + "\", DATE_OF_FINISHING=\"" +
                dateEvent + "\", MARK=\"" +
                mark + "\", FIO=\"" +
                responsibleMan + "\" WHERE orderevents.ORDER_ID="+number);
        if(!event.equals(""))
            answer = jdbc.update("UPDATE orderevents SET ORDEREVENT=\"" +
                    event + "\", DATE_OF_FINISHING=\"" +
                    dateEvent + "\", MARK=\"" +
                    mark + "\", FIO=\"" +
                    responsibleMan + "\" WHERE orderevents.ORDER_ID="+number);
        return answer;
    }

    public boolean deleteOrder(String ID)
    {
        boolean answer=deleteAllEvents(ID);
        if(answer==false)
            return answer;
        answer=jdbc.delete("DELETE FROM orders WHERE orders.ORDER_ID=\""+ID+"\"");
        return answer;
    }

    public boolean deleteEvent(String event)
    {
        boolean answer=jdbc.delete("DELETE FROM orderevents WHERE ORDEREVENT=\""+event+"\"");
        return answer;
    }

    public boolean deleteAllEvents(String ID)
    {
        boolean answer=jdbc.delete("DELETE FROM orderevents WHERE orderevents.ORDER_ID=\""+ID+"\"");
        return answer;
    }

    public boolean deleteCorrespondent(String fio)
    {
        boolean answer=jdbc.delete("DELETE FROM workers WHERE FIO=\""+fio+"\"");
        return answer;
    }

    public String[] getListOrders()
    {
        ArrayList<String> arrayList=jdbc.select("SELECT orders.ORDER_ID FROM orders", JDBC.ORDERS);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public String[] getListOrders(String date)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT * FROM orders WHERE DATE_OF_ADOPTION<=\""+date+"\" ORDER BY DATE_OF_ADOPTION", JDBC.ORDERS_SELECTED_ALL);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
        {
            list[i] = arrayList.get(i);
            System.out.println(list[i]);
        }
        return list;
    }

    public String[] getListEvents(String ID)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT ORDEREVENT FROM orderevents WHERE orderevents.ORDER_ID=\""+ID+"\"", JDBC.ORDER_EVENTS);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i]=arrayList.get(i);
        return list;
    }

    public String[] getListEvents(String beginDate, String endDate)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT * FROM orderevents WHERE DATE_OF_FINISHING BETWEEN \""+beginDate+"\" AND \""+endDate+"\"", JDBC.ORDER_EVENT_SELECTED_ALL);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i] = arrayList.get(i);
        return list;
    }

    public String[] getListEvents(String date, int n)
    {
        ArrayList<String> arrayList=jdbc.select("SELECT * FROM orderevents WHERE DATE_OF_FINISHING<=\""+date+"\" ORDER BY DATE_OF_FINISHING", JDBC.ORDER_EVENT_SELECTED_ALL);
        String[] list=new String[arrayList.size()];
        for(int i=0; i<list.length; i++)
            list[i] = arrayList.get(i);
        return list;
    }
}