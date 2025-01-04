import chisel3._

class Accu extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val setZero = Input(Bool())
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  val accuReg = RegInit(0.U(8.W))
  accuReg := accuReg + 1.U
  when (io.setZero) {
    accuReg := 0.U
  }

  res := accuReg

  // ***** your code ends here *****

  io.dout := res
}

// generate Verilog
object Accu extends App {
  emitVerilog(new Accu())
}
