package net.sperly.focuscraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class FocusTableStone extends FocusTable{

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(1, 4, 4, 15, 14, 15),
            Block.makeCuboidShape(7, 4, 1, 9, 7, 2),
            Block.makeCuboidShape(6, 7, 1, 7, 8, 2),
            Block.makeCuboidShape(9, 7, 1, 10, 8, 2),
            Block.makeCuboidShape(5, 8, 1, 6, 10, 2),
            Block.makeCuboidShape(10, 8, 1, 11, 10, 2)
            ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(1, 4, 1, 12, 14, 15),
            Block.makeCuboidShape(14, 4, 7, 15, 7, 9),
            Block.makeCuboidShape(14, 7, 6, 15, 8, 7),
            Block.makeCuboidShape(14, 7, 9, 15, 8, 10),
            Block.makeCuboidShape(14, 8, 5, 15, 10, 6),
            Block.makeCuboidShape(14, 8, 10, 15, 10, 11)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(1, 4, 1, 15, 14, 12),
            Block.makeCuboidShape(7, 4, 14, 9, 7, 15),
            Block.makeCuboidShape(9, 7, 14, 10, 8, 15),
            Block.makeCuboidShape(6, 7, 14, 7, 8, 15),
            Block.makeCuboidShape(10, 8, 14, 11, 10, 15),
            Block.makeCuboidShape(5, 8, 14, 6, 10, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
            Block.makeCuboidShape(4, 4, 1, 15, 14, 15),
            Block.makeCuboidShape(1, 4, 7, 2, 7, 9),
            Block.makeCuboidShape(1, 7, 9, 2, 8, 10),
            Block.makeCuboidShape(1, 7, 6, 2, 8, 7),
            Block.makeCuboidShape(1, 8, 10, 2, 10, 11),
            Block.makeCuboidShape(1, 8, 5, 2, 10, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public FocusTableStone() {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .harvestLevel(2)
                .hardnessAndResistance(1.5f, 6.0f)
                .setRequiresTool()
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        switch(state.get(FACING)) {
            case DOWN:
                break;
            case UP:
                break;
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                throw new IllegalStateException("Unexpected value: " + state.get(FACING));
        }
        return super.getShape(state,worldIn,pos,context);
    }
}
