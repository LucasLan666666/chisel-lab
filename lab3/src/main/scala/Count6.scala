import chisel3._

class Count6 extends Module {
  val io = IO(new Bundle {
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  val cntReg = RegInit(0.U(3.W))

  cntReg := cntReg + 1.U
  when (cntReg === 6.U) {
    cntReg := 0.U
  }

  res := cntReg

  // ***** your code ends here *****

  io.dout := res
}

// generate Verilog
object Count6 extends App {
  emitVerilog(new Count6())
}
