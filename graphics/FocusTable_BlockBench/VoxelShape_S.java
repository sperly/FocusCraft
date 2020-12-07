Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(1, 4, 1, 15, 14, 12),
Block.makeCuboidShape(7, 4, 14, 9, 7, 15),
Block.makeCuboidShape(9, 7, 14, 10, 8, 15),
Block.makeCuboidShape(6, 7, 14, 7, 8, 15),
Block.makeCuboidShape(10, 8, 14, 11, 10, 15),
Block.makeCuboidShape(5, 8, 14, 6, 10, 15)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});