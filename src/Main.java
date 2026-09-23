//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main()
{
    try (BufferedReader br = new BufferedReader(new FileReader("22 (1).txt")))
    {
        String line;
        int N = 100;
        int[] IdProc = new int[N];
        int[] TimeProc = new int[N];
        String[] BeforeProc = new String[N];
        for(int i = 0; i < N; i++)
        {
            line = br.readLine();
            IdProc[i] = Integer.parseInt(line.split("\t")[0]);
            TimeProc[i] = Integer.parseInt(line.split("\t")[1]);
            BeforeProc[i] = line.split("\t")[2].replaceAll("\"", "");

            IO.print(IdProc[i]);
            IO.print(" ");
            IO.print(TimeProc[i]);
            IO.print(" ");
            IO.println(BeforeProc[i]);
        }
    }
    catch (Exception e)
    {
        throw new RuntimeException(e);
    }
}
