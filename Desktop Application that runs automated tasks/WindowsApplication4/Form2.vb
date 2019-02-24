Public Class Form2

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Using ofd As New OpenFileDialog()
            If ofd.ShowDialog() = DialogResult.OK Then
                TextBox1.Text = ofd.FileName
            End If
        End Using
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        Using ofd As New OpenFileDialog()
            If ofd.ShowDialog() = DialogResult.OK Then
                TextBox2.Text = ofd.FileName
            End If
        End Using
    End Sub

    Private Sub Button3_Click(sender As Object, e As EventArgs) Handles Button3.Click
        Using ofd As New OpenFileDialog()
            If ofd.ShowDialog() = DialogResult.OK Then
                TextBox3.Text = ofd.FileName
            End If
        End Using
    End Sub


    Private Sub Button5_Click(sender As Object, e As EventArgs) Handles Button5.Click
        Using ofd As New OpenFileDialog()
            If ofd.ShowDialog() = DialogResult.OK Then
                TextBox4.Text = ofd.FileName
            End If
        End Using
    End Sub
    Private Sub Button4_Click(sender As Object, e As EventArgs) Handles Button4.Click
        If String.IsNullOrEmpty(TextBox1.Text) Or String.IsNullOrEmpty(TextBox2.Text) Or String.IsNullOrEmpty(TextBox3.Text) Then
            MsgBox("You Must Choose the 3 output files")
            'ElseIf Not TextBox1.Text.EndsWith(".xlsx") Or Not TextBox2.Text.EndsWith(".xlsx") Or Not TextBox3.Text.EndsWith(".xlsx") Then
            '   MsgBox("The files must be of type excel!")
        Else
            System.IO.File.WriteAllText("Files.txt", "")
            Dim file As System.IO.StreamWriter
            file = My.Computer.FileSystem.OpenTextFileWriter("Files.txt", True)
            file.WriteLine(TextBox1.Text)
            file.WriteLine(TextBox1.Text)
            file.WriteLine(TextBox2.Text)
            file.WriteLine(TextBox3.Text)
            file.WriteLine(TextBox4.Text)
            file.Close()
            MsgBox("You succesfully saved your output files!")
            Dim form1 = New Form1()
            Me.Hide()
            form1.Show()
        End If
    End Sub
End Class