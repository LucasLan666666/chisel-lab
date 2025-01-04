import chisel3._

/**
  * Use Mux2 components to build a 4:1 multiplexer
  */

class Mux4 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c = Input(UInt(1.W))
    val d = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val y = Output(UInt(1.W))
  })

  // ***** your code starts here *****

  // create a Mux4 component out of Mux2 components
  // and connect the input and output ports.

  val muxAB    = Module(new Mux2)
  val muxCD    = Module(new Mux2)
  val muxFinal = Module(new Mux2)
  val resAB    = WireDefault(0.U(1.W))
  val resCD    = WireDefault(0.U(1.W))
  val resFinal = WireDefault(0.U(1.W))

  // muxAB
  muxAB.io.a   := io.a
  muxAB.io.b   := io.b
  muxAB.io.sel := io.sel(0)
  resAB := muxAB.io.y
  // muxCD
  muxCD.io.a   := io.c
  muxCD.io.b   := io.d
  muxCD.io.sel := io.sel(0)
  resCD := muxCD.io.y
  // muxFinal
  muxFinal.io.a   := resAB
  muxFinal.io.b   := resCD
  muxFinal.io.sel := io.sel(1)
  resFinal := muxFinal.io.y

  io.y := resFinal

  // ***** your code ends here *****
}

// generate Verilog
object Mux4 extends App {
  emitVerilog(new Mux4())
}
