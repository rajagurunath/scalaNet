package customNet.Tensor
import org.nd4j.linalg.cpu.nativecpu.NDArray;
import botkop.numsca.Tensor


class CustomTensor(override val array: NDArray, override val isBoolean:Boolean = false)
      extends Tensor(array = array,isBoolean = isBoolean) {

}
