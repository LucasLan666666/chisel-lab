import chisel3._
import chisel3.util._

class Decoder extends Module {
  val io = IO(new Bundle {
    val sel = Input(UInt(2.W))
    val out = Output(UInt(4.W))
  })

  val sel = io.sel
  val dec = WireDefault(0.U(4.W))

  // ***** your code starts here *****
  // switch 是 Scala 的语法，应该用 Chisel 的 MuxLookup
  // switch(sel) {
  //   is(0.U) { dec := "b0001".U }
  //   is(1.U) { dec := "b0010".U }
  //   is(2.U) { dec := "b0100".U }
  //   is(3.U) { dec := "b1000".U }
  // }
  dec := MuxLookup(sel, 0.U(4.W)) (Seq(
    0.U(2.W) -> "b0001".U(4.W),
    1.U(2.W) -> "b0010".U(4.W),
    2.U(2.W) -> "b0100".U(4.W),
    3.U(2.W) -> "b1000".U(4.W)
  ))
  // ***** your code ends here *****

  io.out := dec
}

// generate Verilog
object Decoder extends App {
  emitVerilog(new Decoder())
}
