import chisel3._

class Delay extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  val Reg1 = RegInit(0.U(8.W))
  val Reg2 = RegInit(0.U(8.W))

  Reg1 := io.din
  Reg2 := Reg1

  res := Reg2

  // ***** your code ends here *****

  io.dout := res
}

object Delay extends App {
  emitVerilog(new Delay())
}
