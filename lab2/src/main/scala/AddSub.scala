import chisel3._

class AddSub extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(4.W))
    val b = Input(UInt(4.W))
    val selAdd = Input(Bool())
    val y = Output(UInt(4.W))
  })

  val a = io.a
  val b = io.b
  val selAdd = io.selAdd
  val res = WireDefault(0.U(4.W))

  // ***** your code starts here *****

  res := Mux(selAdd, a + b, a - b)

  // ***** your code ends here *****

  io.y := res
}

// generate Verilog
object AddSub extends App {
  emitVerilog(new AddSub())
}
