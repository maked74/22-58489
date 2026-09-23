//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public static class Proc
{
    public String Id;
    public int Duration;
    public String ProcBefore;
}

Proc[] ProcList = new Proc[0];


void main()
{
    try (BufferedReader br = new BufferedReader(new FileReader("22 (1).txt")))
    {
        String line;
        int N = 100;
        ProcList = new Proc[N];
        for(int i = 0; i < N; i++)
        {
            line = br.readLine();

            ProcList[i] = new Proc();
            ProcList[i].Id = line.split("\t")[0];
            ProcList[i].Duration = Integer.parseInt(line.split("\t")[1]);
            ProcList[i].ProcBefore = line.split("\t")[2].replaceAll("\"", "");

//            IO.print(ProcList[i].Id);
//            IO.print(" ");
//            IO.print(ProcList[i].Duration);
//            IO.print(" ");
//            IO.println(ProcList[i].ProcBefore);
        }

        IO.println("Start");

        for(int i = 0; i < N; i++)
        {
            IO.print(ProcList[i].Id);
            IO.print(" ");
            IO.print(ProcList[i].Duration);
            IO.print(" ");
            IO.print(ProcList[i].ProcBefore);
            IO.print(" ");
            IO.println(GetTimeStart(ProcList[i]));
        }
    }
    catch (Exception e)
    {
        throw new RuntimeException(e);
    }
}

Proc GetProc(String idProc)
{
    for (Proc value : ProcList)
    {
        if (Objects.equals(value.Id, idProc))
        {
            return value;
        }
    }
    return null;
}

int GetTimeStart(Proc proc)
{
    int t;
    t = 0;

    Proc cProc = proc;

    boolean flagEnd = false;

    int k = 0;
    int kMax = 10;

    if (Objects.equals(cProc.ProcBefore, "0"))
    {
        flagEnd = true;
    }

    while(!flagEnd && k < kMax)
    {
        if (Objects.equals(cProc.ProcBefore, "0"))
        {
            //t = t + cProc.Duration;
            flagEnd = true;
        }
        else if (!cProc.ProcBefore.contains(";"))
        {
            cProc = GetProc(cProc.ProcBefore);
            t = t + cProc.Duration;
        }
        else
        {
            String procId1 = cProc.ProcBefore.split(";")[0];
            int t1 = GetTimeStart(GetProc(procId1));

            String procId2 = cProc.ProcBefore.split(";")[1];
            int t2 = GetTimeStart(GetProc(procId2));

            if (t2 > t1)
            {
                t = t + t2;
            }
            else
            {
                t = t + t1;
            }
        }

        k++;
    }

    return t;
}
